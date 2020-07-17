const deleteSel = document.getElementById('DeleteSel');
const deleteAll = document.getElementById('btnDelAll');
const content = document.getElementById('content_style');

function delete_sel() {
	
	var array = [];
	var checkboxes = document.querySelectorAll('input[type=checkbox]:checked');

	if(checkboxes.length == 0) {
		var checkbox = document.querySelectorAll('input[type="checkbox"]');
		console.log(checkbox);
		for(var i = 0; i < checkbox.length; i++){
			checkbox[i].checked = true;
		}
		
		checkboxes = document.querySelectorAll('input[type=checkbox]:checked');
	}
	
	for (var i = 0; i < checkboxes.length; i++) {
	  array.push(checkboxes[i].value);
	}


	$.ajax({
		type : 'POST',
        url : './delete',
        data : { 0:0, array : array},
        dataType : 'text',
        contentType: 'application/x-www-form-urlencoded; charset=utf-8',
        success: function(retVal){
            console.log(retVal);
            
       	 if (retVal == "OK") {
       		console.log("성공");
       		location.reload();
       	 } else{
       	 	alert("오류가 발생하였습니다.");
       		console.log("실패");
       	 }
        },
        error:function(request,status,error){
       	 alert("값을 선택하세요");
        }
	});
	
	array= new Array();
}

function update_content_style(num, content) {
	var parent = document.getElementById("td_p");
	var tag_p = document.getElementById("content_style"+ num);
	parent.removeChild(tag_p);
	
	parent.innerHTML = '<input type="text" id="input_content'+num+'" class="content_input" style="float: left;" value="'+content+'">'+
	'<input type="button" id="btn_update" value="확인" onclick="update_content('+num+')">';
}

function update_content(num) {
	var content = document.getElementById("input_content"+ num).value;
	console.log(content);
	console.log(num);

	$.ajax({
		type : 'POST',
        url : './update',
        data : { 'num' : num, 'content' : content},
        dataType : 'text',
        contentType: 'application/x-www-form-urlencoded; charset=utf-8',
        success: function(retVal){
            console.log(retVal);
            
       	 if (retVal == "OK") {
       		console.log("성공");
       		location.reload();
       	 } else{
       	 	alert("오류가 발생하였습니다.");
       		console.log("실패");
       	 }
        },
        error:function(request,status,error){
       	 alert("오류가 발생하였습니다.");
        }
	});
	
}

function update_status(number, status) {
	
	$.ajax({
	type : 'POST',
    url : './updateStatus',
    data : { 'number' : number, 'status' : status},
    dataType : 'text',
    contentType: 'application/x-www-form-urlencoded; charset=utf-8',
    success: function(retVal){
        console.log(retVal);
        
   	 if (retVal == "OK") {
   		console.log("성공");
   		location.reload();
   	 } else{
   	 	alert("오류가 발생하였습니다.");
   		console.log("실패");
   	 }
    },
    error:function(request,status,error){
   	 alert("오류가 발생하였습니다.");
    }
	});
}
