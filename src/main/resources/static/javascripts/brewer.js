var Brewer = Brewer || {}; //Brewer = Brewer and if not exist yet create it ({})

Brewer.MaskMoney = (function() {
	
	//ctor
	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');
	}
	
	MaskMoney.prototype.enable = function() {
		this.decimal.maskMoney( {decimal: ',', thousands: '.'});
		this.plain.maskMoney({precision:0, thousands:'.'});
	}	
	
	return MaskMoney;
	
}());

$(function() {
	var maskMoney = new Brewer.MaskMoney();
	maskMoney.enable();
});