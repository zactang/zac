function asyncLoad(url,param) {
	//is login
	//jQuery.getJSON("/users/islogin",function(data){
	jQuery.post("/users/islogin",function(data){
		if(data=="1"){
			//before asyncLoad
			jQuery.post(url, param,function(data) {
				var arr = jQuery(data);
				var top;
				for ( var i = 0; i < arr.length; i++) {
					if (jQuery(arr[i]).hasClass("container")) {
						top = jQuery(arr[i]);
						break;
					}

				}
				var arr = jQuery(top).nextAll();
				var nrr = jQuery(jQuery(".container")[0]).nextAll();
				for ( var i = 0; i < nrr.length; i++) {
					jQuery(nrr[i]).remove();
				}
				for ( var i = 0; i < arr.length; i++) {
					jQuery("body").append(arr[i]);
				}
			});
		}else{
			window.location="/";
		}
		
	});
	
	
}