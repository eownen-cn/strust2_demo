/**
 * 
 */
var xhr, f, temp_k, temp_v, resp_text;
f_0.onclick = function(e) {
	e.preventDefault();
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			console.log('接收到响应：\n解码之前:', this.responseText);
			resp_text = decodeURI(this.responseText);
			console.log('解码之后:' + resp_text);
			var _temp = JSON.parse(resp_text);
			console.log('转换为JSON之后:', _temp);
			show_ajax_resp.innerText = resp_text;
		}
	}
	xhr.open('post', '/struts2-web06/ajax', true);
	f = new FormData();
	console.log("发送前：");
	console.log("编码前，username:" + f_user_username.value);
	console.log("编码前，password:" + f_user_password.value);

	temp_k = encodeURI(f_user_username.value);
	temp_v = encodeURI(f_user_password.value);

	console.log("第一次编码，username:" + temp_k);
	console.log("第一次编码，password:" + temp_v);

	temp_k = encodeURI(f_user_username.value);
	temp_v = encodeURI(f_user_password.value);

	console.log("第二次编码，username:" + temp_k);
	console.log("第二次编码，password:" + temp_v);

	f.append('username', temp_k);
	f.append('password', temp_v);
	xhr.send(f);
}