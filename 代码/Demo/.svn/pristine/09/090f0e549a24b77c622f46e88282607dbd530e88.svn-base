var SellerScroll = function(options){
	this.SetOptions(options);
	this.lButton = this.options.lButton;
	this.rButton = this.options.rButton;
	this.oMain = this.options.oMain;
	this.oList = this.options.oList;
	this.showSum = this.options.showSum;
	this.widthSum = this.options.widthSum;
	this.moveMaxOffset = this.options.moveMaxOffset;

	this.iList = $(this.options.oList + " > li");
	this.iListSum = this.iList.length;
	this.iListWidth = this.iList.outerWidth(true);
	this.moveWidth = this.iListWidth * this.showSum;

	this.dividers = Math.ceil(this.iListSum / this.showSum);
	this.LeftScroll();
	this.RightScroll();
};
SellerScroll.prototype = { 
	SetOptions: function(id,options){ 
		var num = w = 0, showSum = 1, m = id;
		var u = m+" ul", l = m+" .arrowL", r = m+" .arrowR";
		var liObj = $(u +" li");
		liObj.each(function(){ w += $(this).outerWidth(true); });
		$(u).css({width: w +"px"});
		//var moveMaxOffset = Math.abs(( Math.ceil( liObj.length / showSum) - Math.floor($(m+" .list").width()/w *10)+1) * (liObj.outerWidth(true) * showSum));
		var moveMaxOffset = w - $(m+" .list").width();
		this.options = { 
			lButton: l, 
			rButton: r, 
			oMain: m,
			oList: u, 
			showSum: showSum,
			widthSum: w,
			moveMaxOffset: moveMaxOffset
		};
		$.extend(this.options, options || {});
		//初始隐藏左，判断是否需要隐藏右
		if(this.ReturnLeft()==0){ $(l).css({display:"none"}); }
		if(Math.abs(this.ReturnLeft()) >= moveMaxOffset){ $(r).css({display:"none"}); }
	}, 
	ReturnLeft: function(){ 
		return isNaN(parseInt($(this.oList).css("left"))) ? 0 : parseInt($(this.oList).css("left"));
	},
	LeftScroll: function(){ 
		if(this.dividers == 1) return;
		var _this = this, currentOffset, rbut = $(this.rButton);
		$(this.lButton).click(function(){ 
			currentOffset = _this.ReturnLeft();
			if(currentOffset == 0){
				$(this).css({display:"none"});
			}else{
				rbut.css({display:"block"});
				if(currentOffset==-(_this.moveWidth)){ $(this).css({display:"none"}); }
				$(_this.oList + ":not(:animated)").animate( { left: "+=" + _this.moveWidth }, "slow" );
			} 
		});
	}, 
	RightScroll: function(){ 
		if(this.dividers == 1) return;
		var _this = this, currentOffset, lbut = $(this.lButton);
		$(this.rButton).click(function(){ 
			currentOffset = _this.ReturnLeft();
			if(Math.abs(currentOffset) >= _this.moveMaxOffset){
				$(this).css({display:"none"});
			}else{
				lbut.css({display:"block"});
				if(Math.abs(currentOffset) >= _this.moveMaxOffset-_this.moveWidth){ $(this).css({display:"none"}); }
				$(_this.oList + ":not(:animated)").animate( { left: "-=" + _this.moveWidth }, "slow" );
			}
		});
	}
};