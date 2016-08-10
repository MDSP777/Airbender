$('#purchase').click(function(){
     $('#confirmMessage').text('You are purchasing ' + $('#quantity').val() + ' Shoes 1 for ' + number($('#quantity').val()) * number($('#price').val())+ ' php')
})

$('#quantity').keyup(function(){
     $('#total-price').text('Total Price: ' + number($('#quantity').val()) * number($('#price').val()))
})