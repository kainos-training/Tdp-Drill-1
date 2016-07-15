$(document).ready(function(){


		$('#myForm').validate({
	    rules: {
	       name: {
	        required: true,
	        required: true
	      },
		  
		 title: {

	        required: true

	     },



	    },
			highlight: function(element) {
				$(element).closest('.control-group').removeClass('success').addClass('error');
			},
			success: function(element) {
				element
				.addClass('valid')
				.closest('.control-group').removeClass('error');
			}
	  });

});