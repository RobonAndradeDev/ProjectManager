$(document).ready(function(){
	loginPosition();
	$(window).resize(function(){
		loginPosition();
	});
	if($("#conteinner").data("firsttime")){
		if( $("#conteinner").data("warm") ){
			alert("Email ou senha incorreto.");
		}
	}
});

function loginPosition(){
	$('#conteinner').css('margin-left', function(){
		return ( $(window).width() / 2 ) - ( $('#conteinner').width() / 2 );
	});
	$('#conteinner').css('margin-top', function(){
		return ( $(window).height() / 2 ) - ( $('#conteinner').height() / 2 );
	});
}