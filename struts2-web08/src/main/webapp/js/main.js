/**************Edition start******************/
window.onload = function() {
	var links = document.getElementsByTagName('a') ;
	for ( var i in links ) {
		if ( links[i].href != '' || links[i] != null) {
			links[i].removeAttribute('href') ;
		}
	}
}
var arr_old = new Array(),
arr_new = new Array() ;
function sendAjax(arr){
	var xhr = new XMLHttpRequest(),
		data = new FormData(),
		arr_len = arr.length ;
		data.append('uid',arr[0]) ;
	if ( arr_len< 1) { // 处理错误
		console.log("arr cannot be undefined or null !") ;
	} else if ( arr_len === 1 ) { // 处理删除
		xhr.open('post','/struts2-web08/user/del',true) ;
	} else { // 处理更新
		data.append('username',arr[1]) ;
		data.append('password',arr[2]) ;
		data.append('vipLevel',arr[3]) ;
		xhr.open('post','/struts2-web08/user/edit',true) ;
	}
	xhr.send(data) ;
	xhr.onreadystatechange = function () {
		if ( this.readyState==4 && this.status==200 ) console.info(arr_len>1?'Update success !':arr_len==1?'Delete success !':'nothing !')
	}
	
}

function edit( tar , liid ) {
	arr_new[0] = arr_old[0] = liid ;
	var spans = document.getElementById('li_' +liid).children;
//	console.info(spans) ;
	if (tar.innerText == '修改') {
		tar.innerText = '保存';
		i_wrap(spans,true,liid);
	} else {
		tar.innerText = '修改';
		i_wrap(spans,false,liid);
		if( isChanged(arr_old,arr_new) ) sendAjax(arr_new) ;
	}
}
function i_wrap(s,flag,id) {
	for(var i = 0 , c; i < s.length; i ++) {
		if (i == 1 || i == 2 || i == 3) {
			c = s[i].firstChild ;
			if ( flag ) {
				arr_old[i] = c.value ; // 获取修改之前的值
				c.removeAttribute('disabled') ;
			} else {
				arr_new[i] = c.value ; // 获取修改之后的值
				c.disabled='disabled' ;
			}
		}
	}
	if (!flag) {
		console.log("The old data from changed before : " + arr_old) ;
		console.log("The new data from changed after : " + arr_new) ;
	}
}

function isChanged(o,n) {
	for(var a = 0 ; a < o.length; a ++) {
		if ( o[a] !== n[a] ) return true ; // 发生修改
	}
	return false ; // 没有任何修改
}
/**************Edition end******************/

/**************Delete start******************/

function del(tar,liid) {
	var span_li = document.getElementById('li_' +liid);
	span_li.parentNode.removeChild(span_li) ; // 删除节点
	sendAjax([liid]) ;
}

/**************Delete end******************/