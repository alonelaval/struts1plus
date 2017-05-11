/**
 * PingAnValidate 
 * js验证框架，基于jquery,fValidate
 * @author huawei
 * @version 1.0 2015-2-14
 *
 */
if ( typeof PingAnValidate == 'undefined' )
	{
		var PingAnValidate = new Object();
	}
	
function PingAnValidate(form, errorMode){
		var self        = this;
		this.form       = form;
		this.errorMode  = errorMode;
		this.vadildateErrors     = [];
		this.validated  = true;
		this.errors     ={};
		this.errorMessage  = PingAnValidateLang.errorMessage;
		this.errorClass	= "errorClass";
		this.singleCSS	= false;
		
		
		form.onreset = function()
		{
			var elem, i = 0;
			while ( elem = this.elements[i++] )
			{
				self.revertError( elem );
			}
		}
	
		addLabelProperties();
	
		//	Parses form and adds label properties to elements that have one specified
		function addLabelProperties()
		{
			//	Collect all label elements in form, init vars		
			if ( typeof form.getElementsByTagName == 'undefined' ) return;
			var labels = form.getElementsByTagName( "label" );
			var label, i = j = 0;
			var elem;
	
			//	Loop through labels retrieved
			while ( label = labels[i++] )
			{
				//	For Opera 6
				if ( typeof label.htmlFor == 'undefined' ) return;
				
				//	Retrieve element
				elem =form.elements[label.htmlFor];
				if ( typeof elem == 'undefined' )
				{	//	No element found for label				
					self.devError( [label.htmlFor], 'noLabel' );
				}
				else if ( typeof elem.label != 'undefined' )
				{	//	label property already added
					continue;
				}
				else if ( typeof elem.length != 'undefined' && elem.length > 1 && elem.nodeName != 'SELECT' )
				{	//	For arrayed elements
					for ( j = 0; j < elem.length; j++ )
					{
						elem.item( j ).label = label;
					}
				}
				//	Regular label
				elem.label = label;
			}
	}		
}
PingAnValidate.prototype._reset = function()
{
		this.errors		= [];
}
function pinganValidate(form,errorMode){
		
  		var form         =( typeof form != 'string' ) ? form : $('#'+form)[0];
		var errorMode	 = ( typeof errorMode != 'undefined' ) ? parseInt( errorMode) : 0;
		if ( typeof form.validate == 'undefined' )
		{
			form.validate = new PingAnValidate(form, errorMode);
		} else {		
			form.validate._reset();
			form.validate.errorMode = errorMode;
		}
		var validateCode = 'validate';
		var validateParams;
		var validateType;
		var elem, i = 0;
	
		$.each(form.elements, function(index, elem){
			if ( elem.nodeName == 'FIELDSET' ) 
				 return true;
			
			pararmString = $(this).attr(validateCode) ? $(this).attr(validateCode)  : null;
			
			if ( ( typeof pararmString == 'undefined' || pararmString == null || pararmString == "" ) )
				return true;
				
			validateParams			= pararmString.split( "|" );
			validateType			= validateParams[0];
			elem.validated			= true;
			if(validateParams.last() == 'true'){
				validateParams =validateParams.reduce(1,1);
				elem.blank = true;
			}
			
			if ( typeof form.validate[validateType] == 'undefined' )
			{				
				form.validate.devError( [validateType, elem.name], 'notFound' );
				return false;
			}
			if ( /radio|checkbox/.test( this.type ) )
			{
				elem.group = form.elements[this.name];
			}
			form.validate.elem		= elem;
			form.validate.type		= validateType;

			var func = new Function( "obj", "method", "obj[method]( " + validateParams.toArgString() + " );" );
			func( form.validate, validateType );
			if ( elem.validated == false ) return false;
			
			//	Clear error if field okay
			if ( elem.validated == true ) form.validate.revertError();
			
		});
	if ( form.validate.errors.length > 0 ) return false;	
	
 	return true;
}
 
PingAnValidate.prototype.number = function (type ,lb, ub )
{
	if ( this.typeMismatch( 'text' ) ) return;
	
	var num  = ( type == 0 ) ? parseInt( this.elem.value, 10 ) : parseFloat( this.elem.value );
	lb       = this.setArg( lb, 0 );
	ub       = this.setArg( ub, Number.infinity );
	if ( lb > ub )
	{
		this.devError( [lb, ub, this.elem.name] );
		return;
	}
	var fail = Boolean( isNaN( num ) || num != this.elem.value );
	if ( !fail )
	{
		switch( true )
		{
			case ( lb != false && ub != false ) : fail = !Boolean( lb <= num && num <= ub ); break;
			case ( lb != false ) : fail = Boolean( num < lb ); break;
			case ( ub != false ) : fail = Boolean( num > ub ); break;
		}
	}
	if ( fail )
	{
		this.throwError( [this.elem.fName] );
		return;
	}
	this.elemPass = true;
}

PingAnValidate.prototype.devError = function( args, which )
{
	if ( typeof args == 'string' )
	{
		which = args;
		args = [];
	}
	which = this.setArg( which, this.type );
	var format = this.errorMessage.devErrors[which];
	var a = [
		this.errorMessage.devErrors.lines[0],
		'----------------------------------------------------------------------------------------------',
		this.translateMessage( args, format ),
		'----------------------------------------------------------------------------------------------',
		this.errorMessage.devErrors.lines[1]
		];
	alert( a.join( "\n" ) );
}


PingAnValidate.prototype.translateMessage = function( args, format )
{
	var msg		= ""
	for ( var i = 0; i < format.length; i++ )
	{			
			msg += ( typeof format[i] == 'number' ) ? args[format[i]] : format[i];
	}
	return msg;
}

PingAnValidate.prototype.typeMismatch = function()
{
	var pats = {
		'text':		'text|password|textarea',
		'ta':		'textarea',
		'hidden':	'hidden',
		's1':		'select-one',
		'sm':		'select-multiple',
		'select':	'select-one|select-multiple',
		'rg':		'radio',
		'radio':	'radio',
		'cb':		'checkbox',
		'file':		'file'
		};
	var fail		= false,
		expected	= new Array(),
		result = key = type = regex = "";
	for ( var i = 0; i < arguments.length; i++ )
	{
		type	= pats[arguments[i]];
		regex	= new RegExp( type );
		result	+= ( regex.test( this.elem.type ) ) ? "1" : "0";
		key		+= "0";
		expected.push( type );		
	}
	if ( key ^ result == 0 )
	{
		this.devError( [this.elem.fName, this.elem.type, expected.join( "|" ).replace( /\|/g, this.i18n.or )], 'mismatch' );
		this.elem.validated = false;
		return true;
	}
	return false;
}

PingAnValidate.prototype.revertError = function( elem )
{
	elem = this.setArg( elem, this.elem );
	var isHidden	= Boolean( elem.type == 'hidden' ),
		errorClass	= this.errorClass,
		i			= 0,
		errorElem,
		subelem;

	if ( ( typeof elem.length != 'undefined' && elem.length > 1 && elem.nodeName != 'SELECT' ) || isHidden )
	{
		if ( isHidden && typeof elem.fields != 'undefined' )
		{		
			while( subelem = ( isHidden ) ? elem.fields[i++] : elem.item( i++ ) )		
			{
				if ( typeof subelem.revertClass != 'undefined' )
				{
					subelem.className = subelem.revertClass;
				}
			}
		}
	} else {
		if ( this.singleCSS )
		{
			if ( typeof subElement.revertClass != 'undefined' )
			{
				elem.className = elem.revertClass;
			}
		} else {
			this.removeCSSClass( elem, errorClass );
		}		
	}
	if ( typeof elem.label != 'undefined' )
	{
		if ( this.singleCSS )
		{
			elem.label.className = '';
		} else {
			this.removeCSSClass( elem.label, errorClass );
		}
		elem.label.innerHTML = ( elem.label.original || elem.label.innerHTML );
	}
	if ( typeof this.boxError != 'undefined' )
	{
		if ( typeof this.boxError.normalize != 'undefined' ) this.boxError.normalize();
		if ( errorElem = document.getElementById( this.config.boxErrorPrefix + elem.name ) )
		{
			this.boxError.removeChild( errorElem );
		}
		if ( this.boxError.childNodes.length == 0 ) this.boxError.style.display = "none";
	}
}
PingAnValidate.prototype.removeCSSClass = function( elem, className )
{
	elem.className = elem.className.replace( className, "" ).trim();
}
PingAnValidate.prototype.addCSSClass = function( elem, className )
{
	this.removeCSSClass( elem, className );
	elem.className = ( elem.className + " " + className ).trim();
}
/*	Returns value(s) of reference element passed
------------------------------------------- */
PingAnValidate.prototype.getValue = function( elem )
{
	switch ( elem.type )
	{
		case 'text' :
		case 'password' :
		case 'textarea' :
		case 'hidden' :
		case 'file' :
			return elem.value;
		case 'radio':
		case 'select-single':
			if ( typeof elem.length == 'undefined' )
			{
				return elem.value;
			} else {
				for ( var i = 0; i < elem.length; i++ )
				{
					choice = ( elem.type == 'radio' ) ? "checked" : "selected";
					if ( elem[i][choice] )
					{
						return elem[i].value;
					}
				}
			}
		case 'select-multiple' :
		case 'checkbox' :
			if ( typeof elem.length == 'undefined' )
			{
				return elem.value
			} else {
				var returnValues = new Array();
				for ( var i = 0; i < elem.length; i++ )
				{
					choice = ( elem.type == 'checkbox' ) ? "checked" : "selected";
					if ( elem[i][choice] )
					{
						returnValues.push( elem[i].value );
					}
				}
				return returnValues;
			}
		default: return null;
	}
}
PingAnValidate.prototype.setArg = function( which, type )
{
	return ( typeof which == 'undefined' || which == '' || which == null ) ? type : which;
}

PingAnValidate.prototype.throwError = function( args, which )
{
	var elem  = this.elem;

	//	Arrayed element?
	if ( typeof elem.name == 'undefined' )
	{
		elem = elem[0];
	}

	//	Bok requested AND element blank OR conditional validation?
	if ( elem.blank && this.isBlank() )
	{	//	skip		
		elem.validated = true;
		return;
	}

	//	Part of a conditional validation?
	if ( elem.cv )
	{
		return;
	}
	
	//	Set failsafe to false	
	elem.validated = false;

	//	Create error message
	which	= this.setArg( which, 0 );
	args	= this.setArg( args, [] );
	emsgElem = ( typeof this.elem.getAttribute == "undefined" ) ? this.elem[0] : this.elem;
	
	var nullMsg = $(emsgElem).attr('nullMsg');
	var formatMsg =$(emsgElem).attr('formatMsg');;
	var error;
	if (nullMsg)
	{
		 error = nullMsg;
	}
	else if(formatMsg)
	{
			 error = formatMsg;
	}else{
	 	error = this.translateMessage( args, this.errorMessage.errors[this.type][which] );
	}
	
	//	Group error mode?
	if ( this.groupError )
	{
		//	Push error onto stack
		this.errors.push( {'elem':elem, 'msg': error} );		
	}
	else
	{
		//	Process error message		
		this.showError( error, false, emsgElem );

		var focusElem = ( typeof elem.fields != 'undefined' )?
			elem.fields[0]:
			elem;
		
		//	Focus and select elements, if possible
		this.selectFocus( focusElem );
	}
}

PingAnValidate.prototype.showError = function( emsg, last, elem )
{
	//	Set variables
	var self		= this;
		elem		= this.setArg( elem, this.elem );
		isHidden	= Boolean( elem.type == 'hidden' );
		label		= ( isHidden ) ? null : elem.label || null;
//		emsg		= ( elem.getAttribute( this.config.emsg ) ) ? elem.getAttribute( this.config.emsg ).replace( /\\n/g, "\n" ) : emsg,
	var	errorClass	= this.errorClass;
	var	singleCSS	= this.singleCSS;

	if ( typeof this.showErrors == 'undefined' ) this.showErrors = new Array();	
	
	//	Determine which error modes to use
	switch( this.errorMode )
	{	//	This represents all possible combinations
		case 0  : alertError(); break;
		case 1  : inputError(); break;
		case 2  : labelError(); break;
		case 3  : appendError(); break;
		case 4  : boxError(); break;
		case 5  : inputError(); labelError(); break;
		case 6  : inputError(); appendError(); break;
		case 7  : inputError(); boxError(); break;
		case 8  : inputError(); alertError(); break;
		case 9  : labelError(); appendError(); break;
		case 10 : labelError(); boxError(); break;
		case 11 : labelError(); alertError(); break;
		case 12 : appendError(); boxError(); break;
		case 13 : appendError(); alertError(); break;
		case 14 : boxError(); alertError(); break;
		case 15 : inputError(); labelError(); appendError(); break;
		case 16 : inputError(); labelError(); boxError(); break;
		case 17 : inputError(); labelError(); alertError(); break;
		case 18 : inputError(); appendError(); boxError(); break;
		case 19 : inputError(); appendError(); alertError(); break;
		case 20 : inputError(); boxError(); alertError(); break;
		case 21 : labelError(); appendError(); boxError(); break;
		case 22 : labelError(); appendError(); alertError(); break;
		case 23 : appendError(); boxError(); alertError(); break;
		case 24 : inputError(); labelError(); appendError(); boxError(); break;
		case 25 : inputError(); labelError(); appendError(); alertError(); break;
		case 26 : inputError(); appendError(); boxError(); alertError(); break;
		case 27 : labelError(); appendError(); boxError(); alertError(); break;
		case 28 : inputError(); labelError(); appendError(); boxError(); alertError(); break;		
	}
	//	Regular alert error
	function alertError()
	{
		if ( self.groupError ) self.showErrors.push( emsg );
		else alert( emsg );
		if ( last ) alert( self.errorMessage.groupAlert + self.showErrors.join( "\n\n- " ) );			
	}
	//	Applies class to form element
	function inputError()
	{
		if ( ( typeof elem.length != 'undefined' && elem.length > 1 && elem.nodeName != 'SELECT' ) || isHidden )
		{
			var subelem, i = 0;
			while( subelem = ( isHidden ) ? elem.fields[i++] : elem.item( i++ ) )			
			{
				if ( subelem.className != '' && singleCSS )
				{
					subelem.revertClass = subelem.className;
					subelem.className = errorClass;
				} else {
					self.addCSSClass( subelem, errorClass );
				}				
			}
		}
		else
		{
			if ( singleCSS )
			{
				elem.revertClass = elem.className;
				elem.className = errorClass;
			} else {
				self.addCSSClass( elem, errorClass );
			}
		}
	}
	//	Applies class to element's label
	function labelError()
	{
		if ( label == null ) return;
		if ( singleCSS )
		{
			label.className = errorClass;
		} else {
			self.addCSSClass( label, errorClass );
		}
		
	}
	//	Appends error message to element's label
	function appendError()
	{
		if ( label == null || typeof label.innerHTML == 'undefined' ) return;
		if ( typeof label.original == 'undefined' )
			label.original = label.innerHTML;
		label.innerHTML = label.original + " - " + emsg.toHTML();
	}
	//	Appends Error message to pre-defined element
	function boxError()
	{
		if ( typeof self.boxError == 'undefined' ) self.boxError = document.getElementById( self.config.boxError );
		if ( self.boxError == null )
		{			
			self.devError( [self.config.boxError], 'noBox' );
			return;
		}
		if ( typeof self.elem.name == 'undefined' || self.elem.name == "" )
		{
			self.devError( [self.elem[self.config.code]], 'missingName' );
			return;
		}
		var errorId = self.config.boxErrorPrefix + self.elem.name,
			errorElem;
		if ( errorElem = document.getElementById( errorId ) ) // short-circuit
		{
			errorElem.firstChild.nodeValue = emsg.toHTML();
		}
		else
		{
			errorElem = document.createHTMLElement( 'li', { id: errorId, 'innerHTML': emsg.toHTML(), title: self.errorMessage.boxToolTip } );
			self.boxError.appendChild( errorElem );
			errorElem.onclick = function()
			{
				var elem = self.form.elements[this.id.replace( self.config.boxErrorPrefix, "" )];
				if ( typeof elem.fields != 'undefined' ) elem = elem.fields[0];
				if ( typeof elem.select != 'undefined' ) elem.select();
				if ( typeof elem.focus != 'undefined' ) elem.focus();
			}
		}
		self.boxError.style.display = "block";
	}
}


PingAnValidate.prototype.selectFocus = function( elem )
{
	if ( typeof elem.select != 'undefined' ) elem.select();
	if ( typeof elem.focus != 'undefined' )  elem.focus();
}
PingAnValidate.prototype.isBlank = function( el )
{
	var elem = this.form.elements[el] || this.elem;
	return Boolean( /^\s*$/.test( elem.value ) );
}




Array.prototype.last = function()
{
	return this[this.length-1];
}
Array.prototype.toArgString = function()
{
	var a = new Array();
	for ( var i = 0; i < this.length; i++ )
	{
		a.push( "'" + this[i] + "'" );
	}	
	return a.toString();
}



Array.prototype.reduce = function( b, e )
{
	var a = new Array();
	var count = 0;
	for ( var i = b; i < this.length - e; i++ )
	{
		a[count++] = this[i];
	}
	return a;
}