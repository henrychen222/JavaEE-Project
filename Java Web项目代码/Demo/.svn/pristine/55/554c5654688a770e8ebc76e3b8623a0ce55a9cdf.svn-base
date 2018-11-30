/**
 * 年月范围选择
 *
 * <code>
 * <input type="hidden" name="beginYear" />
 * <input type="hidden" name="beginMonth" />
 * <input type="hidden" name="endYear" />
 * <input type="hidden" name="endMonth" />
 * <input type="text" id="daterange" readonly="readonly" />
 * <script type="text/javascript">
 *   $('#daterange').daterange({
 *     beginYear: 2010,
 *     endYear: 2000
 *   });
 * </script>
 * </code>
 */
(function($) {
	$.fn.daterange = function(options) {
		var opts = $.extend($.fn.daterange.defaults, options);
		var $drDiv = initDaterange();

		$(this).addClass($.fn.daterange.defaults.markerClassName).unbind(
				'focus').bind('focus', {
			mainDiv : $drDiv
		}, showDaterange);
	};

	$.fn.daterange.defaults = {
		markerClassName : 'hasDaterange',
		divClassName : 'ui-dateRange',
		beginYear : 1900,
		endYear : 2099
	};

	// 初始化年月范围选择层
	function initDaterange() {
		var divId = $.fn.daterange.defaults.divClassName
				+ $.fn.daterange.defaults.beginYear
				+ $.fn.daterange.defaults.endYear;
		var $drDiv = $('#' + divId);
		if ($drDiv.length == 0) {
			$drDiv = $('<div />').attr('id', divId).attr("noWrap", true)
					.addClass($.fn.daterange.defaults.divClassName).css(
							'position', 'absolute').css('display', 'none');
			// 年份
			var $selYear = $('<select />').css('width', 'auto');
			for ( var i = $.fn.daterange.defaults.endYear; i >= $.fn.daterange.defaults.beginYear; i--) {
				$selYear.append('<option value="' + i + '" label="' + i + '">'
						+ i + '</option>');
			}
			// 月份
			var $selMonth = $('<select />').css('width', 'auto');
			for ( var i = 1; i <= 12; i++) {
				$selMonth.append('<option value="' + i + '" label="' + i + '">'
						+ i + '</option>');
			}
			// 确定按钮
			var $btnOk = $('<button type="button" />').addClass('btnDefault')
					.unbind('mouseover mouseout click').hover(function() {
						$(this).addClass('btnHover');
					}, function() {
						$(this).removeClass('btnHover');
					});
			var $btnClear = $btnOk.clone(true).text('清空').css('marginLeft', 3)
					.bind(
							'click',
							function() {
								$(this).nextAll('div').hide();
								$drDiv.prev().prev('input').val('').prev(
										'input:hidden').val('').prev(
										'input:hidden').val('').prev(
										'input:hidden').val('').prev(
										'input:hidden').val('');
								hideDaterange();
							});
			$btnOk
					.text('确定')
					.bind(
							'click',
							function() {
								var $sel = $(this).siblings('select');
								if (parseInt($sel[0].value) < parseInt($sel[2].value)
										|| ($sel[0].value == $sel[2].value && parseInt($sel[1].value) < parseInt($sel[3].value))) {
									$(this).nextAll('div').hide();
									$drDiv.prev().prev('input').val(
											$sel[0].value + '.' + $sel[1].value
													+ ' - ' + $sel[2].value
													+ '.' + $sel[3].value)
											.prev('input:hidden').val(
													$sel[3].value).prev(
													'input:hidden').val(
													$sel[2].value).prev(
													'input:hidden').val(
													$sel[1].value).prev(
													'input:hidden').val(
													$sel[0].value);
									hideDaterange();
								} else {
									$(this).nextAll('div').show();
								}
							});
			// 出错提示
			var $errMsg = $('<div />').css('color', '#ff0000').css('display',
					'none').text('结束时间必须晚于起始时间');

			$drDiv.append($selYear).append(' 年 ').append($selMonth).append(
					' 月 至 ').append($selYear.clone()).append(' 年 ').append(
					$selMonth.clone()).append(' 月 ').append($btnOk).append(
					$btnClear).append($errMsg);
			$(document).mousedown(checkExternalClick).find('body').append(
					$drDiv);
		}
		return $drDiv;
	}

	// 显示化年月范围选择层
	function showDaterange(event) {
		// 隐藏所有
		hideDaterange();

		// 显示位置
		var obj = this;
		while (obj && (obj.type == 'hidden' || obj.nodeType != 1)) {
			obj = obj['nextSibling'];
		}
		var position = $(obj).offset();

		// 初始值
		var $eMonth = $(this).prev('input:hidden'), $eYear = $eMonth
				.prev('input:hidden'), $bMonth = $eYear.prev('input:hidden'), $bYear = $bMonth
				.prev('input:hidden');
		var $mainDiv = event.data.mainDiv;
		var $sel = $mainDiv.children('select');
		$sel[0].value = $bYear.val();
		$sel[1].value = $bMonth.val();
		$sel[2].value = $eYear.val();
		$sel[3].value = $eMonth.val();

		// 显示
		$(this).after($mainDiv.css( {
			left : position.left,
			top : position.top + this.offsetHeight + 1,
			display : ''
		}));

		// 加iframe垫片
		var $drShim = $('#drShim');
		if ($drShim.length == 0) {
			$drShim = $('<iframe id="drShim" frameBorder="1" scrolling="no" />')
					.css('position', 'absolute');
		}
		$mainDiv.before($drShim.css( {
			left : position.left,
			top : position.top + this.offsetHeight + 1,
			width : $mainDiv.attr('clientWidth'),
			height : $mainDiv.attr('clientHeight')
					+ parseInt($mainDiv.css('borderWidth')) * 2,
			display : ''
		}));
	}

	// 隐藏化年月范围选择层
	function hideDaterange() {
		$('#drShim').hide();
		$('.' + $.fn.daterange.defaults.divClassName).hide();
	}

	// 点击页面其他位置时隐藏年月范围选择层
	function checkExternalClick(event) {
		if ($(':visible.' + $.fn.daterange.defaults.divClassName).length == 0) {
			return;
		}
		var $target = $(event.target);
		if (!$target.first().hasClass($.fn.daterange.defaults.divClassName)
				&& $target.parents('.' + $.fn.daterange.defaults.divClassName).length == 0
				&& !$target.hasClass($.fn.daterange.defaults.markerClassName)) {
			hideDaterange();
		}
	}
})(jQuery);
