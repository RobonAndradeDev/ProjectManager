//JavaScript file
$(document).ready(function(){
	windowPosition();
	$(window).resize(function(){
		windowPosition();
	});
	$('#updateMyProjects').click(function(){
		$.post('controller.jsp', {classe: "HoraDAO", command: "List"}, function(callback){
			$('#myProjectContent').html(callback);
		});
	});
	$('#updateAllProjects').click(function(){
		$.post('controller.jsp', {classe: "ProjectDAO", command: "List"}, function(callback){
			$('#allProjectContent').html(callback);
		});
	});
});

function windowPosition(){
	$('#centerDiv').width(function(){
		return $(window).width() - 228;
	});	
}