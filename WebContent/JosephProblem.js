function show() {

	var a = document.getElementById('stringarraay').value;
	//$(a).val()
	// 显示
	// document.getElementById('result').innerText = a;
	var li = document.createElement('li');
	li.innerText = a;

	document.getElementById('josephlist').appendChild(li);
	// var p_class = $("#josephlist li").attr("class"); //获取p元素的class
	// 使用attr()方法来设置p元素的class，JQuery代码如下：

	//$("#josephlist li").attr("class", "litag"); // 设置p元素的class为 "high"
	// alert('hello');
	// 鼠标点击li标签输入框显示li标签内容；
	$('#josephlist').on('click', 'li', function() {
		// 弹出点击的li标签的value值
		//var Uarry = $("#josephlist li");
		//var count = $(this).index();// 获取li的下标
		//var Tresult = Uarry.eq(count).text();
		//$("#stringarraay").val(Tresult); // alert('hello');
		//$('#hiddendiv').css("display", "block");
	//	$(this).siblings('li').removeClass('selected');  // 删除其他兄弟元素的样式
      //  $(this).addClass('selected');                            // 添加当前元素的样式

	});
	// 鼠标悬浮时显示hiddendiv
	$('li').hover(function(){
		$('#hiddendiv').css("display", "block");
		$(this).siblings('li').removeClass('selected');  // 删除其他兄弟元素的样式
        $(this).addClass('selected');    
	    console.log("show menu");
	},function(){

		//$('#hiddendiv').css("display", "none");
	}
	);
	$("#stringarraay").val("");
	
	//在空白处单击，隐藏hiddendiv和高亮的标签
	$(document).click(function(event){
		  var _con = $('.josephlistscrolling');   // 设置目标区域
		  if(!_con.is(event.target) && _con.has(event.target).length === 0){ // Mark 1
			//$('#divTop').slideUp('slow');   //滑动消失
			  $('#hiddendiv').css("display", "none");   //淡出消失
			  $('.selected').css("background-color","#ffffff");
		  }
	});
}
function IsNum(s) {

	if (s != null && s != "") {
		var r, re;
		re = /\d*/i; // \d表示数字,*表示匹配多个数字
		r = s.match(re);
		return (r == s) ? true : false;
	}
	return false;
	
}
function sub() {
	
	$("#result").val("");
	var persons = [];
	$("#josephlist li").each(function(i, dom) {
		persons[i] = $(this).text();
	});


	if (IsNum($("#interval").val())==true && IsNum($("#startindex").val())==true) {
		var interval = $("#interval").val();
		var startIndex = $("#startindex").val();
	} else {
		//alert("please input a number!");
		console.log("please input a number!");
		return;

	}

	var jsondata = {
		    "circle": {
		        "start":interval,
		        "interval": startIndex,
		        "persons":persons
		    }
	};
	var encoded = JSON.stringify(jsondata);
	$.ajax({
		type : "post",
		dataType : "json",
		contentType : "application/json;char-set=utf-8",
		url : "josephservlettest",
		data : encoded,
		success : function(data, textStatus) {
			$("#result").val(data.person);
			var objs = eval(data); // 解析json对象
			var obj = objs[0];
		
		},
	error: function (XMLHttpRequest, textStatus, errorThrown) {  
		    //textStatus的值：null, timeout, error, abort, parsererror  
		    //errorThrown的值：收到http出错文本，如 Not Found 或 Internal Server Error.  
			// alert(textStatus); 
			window.location.href ='wrongpage.html';
			 
		}
	
	});

}
//
function clearall() {
	$('ol li').each(function() {
		$(this).remove();
	});
	$("#interval").val("").focus();
	$("#startindex").val("");
	$("#stringarraay").val("");
}

function showdiv(obj, id) {
	var objDiv = $("#" + id + "");
	$(objDiv).css("display", "block");

}
function hidediv(obj, id) {
	var objDiv = $("#" + id + "");
	$(objDiv).css("display", "none");
}
function deleteli(){
	$("li.selected").remove();
	$('#hiddendiv').css("display", "none");
	 console.log("delete li");
}
function insertli(){

	$("li.selected").before("<li>"+$("#stringarraay").val()+"</li>");
	$('#hiddendiv').css("display", "none");
}
function moveupli(){
	if($("li.selected").prev())                    // 如果存在上一个元素
        $("li.selected").prev().before($("li.selected"));    // 就将此元素插到上一个元素之后，从而实现互换顺序
	$('#hiddendiv').css("display", "none");
}
function movedownli(){
	if($("li.selected").next())                    // 如果存在下一个元素
        $("li.selected").next().after($("li.selected"));    // 就将此元素插到下一个元素之后，从而实现互换顺序
	$('#hiddendiv').css("display", "none");
	
}
function renameli(){
	$("li.selected").text($("#stringarraay").val());
	$('#hiddendiv').css("display", "none");
	
}