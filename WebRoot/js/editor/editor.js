
function sonwin(){
	//alert("dad: "+window.opener.document.getElementsByClassName("option")[0].innerHTML);
	var orderid=window.opener.orderid;
	
	var topicinput=document.getElementsByTagName("input")[0].value;
	//alert(topicinput+"---"+orderid);
	window.opener.document.getElementsByTagName("ul")[orderid-1].parentNode.getElementsByTagName("div")[1].innerHTML=topicinput;
	//alert("gg");
	var optionsize=window.opener.document.getElementsByTagName("ul")[orderid-1].getElementsByClassName("option").length;
	//alert(optionsize);	
	var optioninput=null;
	for(var i=0;i<optionsize;i++){
		optioninput=document.getElementsByTagName("input")[i+1].value;
		//alert(optioninput);
		window.opener.document.getElementsByTagName("ul")[orderid-1].getElementsByClassName("option")[i].innerHTML=optioninput;
	}
	window.close();
}

	