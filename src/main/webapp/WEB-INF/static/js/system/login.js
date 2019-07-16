$(function(){
	var clientWidth = $(document.body).outerWidth();
	var c_oneTop=$('.cloud1').position().left;
	var c_twoTop=$('.cloud2').position().left;
	setInterval(function(){
		c_oneTop+=1.2;
		c_twoTop+=1;
		if(c_oneTop>=clientWidth){
			c_oneTop=-500;
		}
		if(c_twoTop>=clientWidth){
			c_twoTop=-500;
		}

		$('.cloud1').css({'left':c_oneTop+'px'});
		$('.cloud2').css({'left':c_twoTop+'px'});
	},50);
})