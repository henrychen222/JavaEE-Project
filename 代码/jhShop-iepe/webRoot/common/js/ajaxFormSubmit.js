//将form转为AJAX提交
	  function ajaxSubmit(url,frm,fn) {
	   var dataPara = getFormJson(frm);
	   $.ajax({
	    url: url,
	    type: 'post',
	    data: dataPara,
	       async:false,  
	      dataType:'text',
	    success: fn
	   });
	  }
	 
	//将form中的值转换为键值对。
	  function getFormJson(frm) {
	   var o = {};
	   var a = $(frm).serializeArray();
	   $.each(a, function () {
	    if (o[this.name] !== undefined) {
	     if (!o[this.name].push) {
	      o[this.name] = [o[this.name]];
	     }
	     o[this.name].push(this.value || '');
	    } else {
	     o[this.name] = this.value || '';
	    }
	   });
	 
	  return o;
	  }