package com.zw.zXing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.zw.domain.Code;
import com.zw.mapper.CodeMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * @author zhongsj
 * @date 2018/07/05
 */


/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2018/8/14 18:36
 */
public class CreateQRcode {


    private  CodeMapper codeMapper;

    private static final int BLACK = 0x00000000;

    private static final int WHITE = 0xFFFFFFFF;

    private static final Map<EncodeHintType, Object> hints = new HashMap();// 二维码参数

    static {
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);// 容错等级 L、M、Q、H 其中 L 为最低, H 为最高
        hints.put(EncodeHintType.MARGIN, 0);// 二维码与图片边距
    }

    public CreateQRcode() {

    }

    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }


    private static void writeToFile(BitMatrix matrix, String format, HttpServletResponse response)
            throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        String path = getLocalPath();
        File outputFile = new File(path+"QRcode.png");
        if (!ImageIO.write(image, format, outputFile)) {
            throw new IOException("Could not write an image of format "
                    + format );
        }
        InputStream inputStream = new FileInputStream(outputFile);
        byte data[];
        try {
            int i = inputStream.available(); //得到文件大小

            data = new byte[i];

            inputStream.read(data); //读数据
        }catch (IOException e){
            throw CommonException.exception("生成二维码失败！");
        }finally {
            IOUtils.closeQuietly(inputStream);
        }

        response.setContentType("image/png"); //设置返回的文件类型

        OutputStream toClient=response.getOutputStream(); //得到向客户端输出二进制数据的对象

        try {
            toClient.write(data); //输出数据
        }catch (IOException e){
            throw CommonException.exception("生成二维码失败！");
        }finally {
            toClient.close();
        }
        outputFile.delete();//删除二维码
    }


    public static void addImageQRcode(String text,int width,int height,String format,HttpServletResponse response)throws Exception {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text,

                BarcodeFormat.QR_CODE, width, height, hints);

        // 生成二维码
        CreateQRcode.writeToFile(bitMatrix, format, response);
    }

    private static String getLocalPath() {
        String localPath;
        if (isWindowPlatform()) {
            localPath = "D:\\data\\hyzs\\";
        } else {
            localPath = "/data/hyzs/";
        }
        File file = new File(localPath);
        //不存在路径
        if (!file.exists()) {
            file.mkdirs();
        }
        return localPath;
    }

    /**
     * 判断系统版本是否为Windows
     * @return
     */
    private static Boolean isWindowPlatform(){
        if (System.getProperties().getProperty("os.name").toLowerCase().contains("windows")){
            return true;
        }else{
            return false;
        }

    }

    public static InputStream changeMerchantSeatQrcodeImage(BufferedImage zxingImage, String backgroundPath,String text) {
        InputStream imagein = null;
        ImageOutputStream imOut = null;
        try {
            imagein = new FileInputStream(backgroundPath);
            BufferedImage image = ImageIO.read(imagein);
            Graphics2D g = (Graphics2D) image.getGraphics();
            g.drawImage(zxingImage, 300, 100,
                    zxingImage.getWidth(), zxingImage.getHeight(), null);
            g.setColor(Color.black);// 再换成黑色，以便于写入文字
            g.setFont(new Font("微软雅黑", Font.BOLD, 30));
            g.drawString(text,130,255);
            // 释放对象
            g.dispose();
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            imOut = ImageIO.createImageOutputStream(bs);
            ImageIO.write(image, "jpg", imOut);
            InputStream is = new ByteArrayInputStream(bs.toByteArray());
            return is;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                imagein.close();
                imOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void createCode() throws Exception {
        List<Code> list = codeMapper.listCode();

        for(Code code:list){
            BitMatrix bitMatrix = new MultiFormatWriter().encode(code.getCode(),
                    BarcodeFormat.QR_CODE, 230, 230, hints);
            BufferedImage image = toBufferedImage(bitMatrix);
            InputStream inputStream = changeMerchantSeatQrcodeImage(image,"C:\\Users\\Administrator\\Desktop\\报业二维码\\报业二维码\\报业报刊亭-04.png",code.getCode());
            File outFile = new File("C:\\Users\\Administrator\\Desktop\\报业二维码\\报业二维码\\二维码\\"+code.getCode()+".jpg");
            FileUtils.copyInputStreamToFile(inputStream,outFile);
        }

    }

}
