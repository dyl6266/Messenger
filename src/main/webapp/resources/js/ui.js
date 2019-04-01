$(function(){
	// Gnb
	$(".gnb_wrap .depth1 > li").hover(function(){
		$(".header_wrap").addClass("on");
	});
	$(".gnb").mouseleave(function(){
		$(".header_wrap").removeClass("on");
	});


	// 화면사이즈 변화감지
	$( window ).resize(function() {
		var windowWidth = $( window ).width();
			if(windowWidth < 1000) {
				$(".header_wrap").removeClass("web_header");
			} else {
				$(".header_wrap").addClass("web_header");
			}
	}).resize();


	// Sticky menu
	$(window).scroll(function(){
		var scrollTop = $(document).scrollTop();
		scrollTop > 0 ? $('.header_wrap').addClass('active') : $('.header_wrap').removeClass('active');
	});
});


// Mobile gnb open/close
function gnbOpen (_this) {
	var _this= $(_this);
	_this.parents(".header_wrap").stop().find(".gnb_wrap").stop().animate({right:"0"},200);
	_this.parents(".header_wrap").find(".opacity_bg").show();
}
function gnbClose (_this) {
	var _this= $(_this);
	_this.parents(".header_wrap").stop().find(".gnb_wrap").animate({right:"-240px"},200);
	_this.parents(".header_wrap").find(".opacity_bg").hide();
}
function menuOpen (_this) {
	var _this = $(_this);
	if (_this.parent().hasClass("on")) {
		_this.parents(".depth1").find(">li").removeClass("on");
		_this.parent().find(".depth2").stop().slideUp(200);
	}else {
		_this.parents(".depth1").find(">li").removeClass("on");
		_this.parents(".depth1").find(".depth2").stop().slideUp(200);
		_this.parent().addClass("on");
		_this.parent().find(".depth2").stop().slideDown(200);
	}
}


// Tooltip 
function tooltipFunc (_this) {
	var _this = $(_this);
	_this.find(".tooltip").toggle();
}


// Accodian
function accodianFunc (_this) {
	var _this = $(_this);
	if (_this.closest("li").hasClass("active")) {
		_this.closest("ul").find("li").removeClass("active");
		_this.closest("ul").find("li .text").stop().slideUp(200);
	}else {
		_this.closest("ul").find("li").removeClass("active");
		_this.closest("ul").find("li .text").stop().slideUp(200);
		_this.closest("li").addClass("active");
		_this.closest("li").find(".text").stop().slideDown(200);
	}
}


// 역경매 입찰자 상세보기
function viewDetail (_this) {
	var _this = $(_this);
	if (_this.closest("li").hasClass("active")) {
		_this.removeClass("active");
		_this.closest("li").removeClass("active");
		_this.closest("li").find(".view_detail").stop().slideUp(200);
	}else {
		_this.addClass("active");
		_this.closest("li").addClass("active");
		_this.closest("li").find(".view_detail").stop().slideDown(200);
	}
}
