/*********************************************************
*
*--	fValidate US-English language file.
*
*	Translation by: Peter Bailey
*	Email: me@peterbailey.net
*
*	Visit http://www.peterbailey.net/fValidate/api/i18n/
*	for additional translations and instructions on
*	making your own translation.
*
*	!!! WARNING !!! Changing anything but the literal 
*	strings will likely cause script failure!
*
*	Note: This document most easily read/edited with tab-
*	spacing set to 4
*
*********************************************************/

if ( typeof PingAnValidateLang == 'undefined' )
{
	var PingAnValidateLang = new Object();
}

PingAnValidateLang.errorMessage =
{
	//	Validation errors
	errors:
	{
		blank:		[
			["请输入 ", 0]
			],
		length:		[
			["请输入 ", 0],
			[0, " 至少为 ", 1, " 个字符长"],
			[0, " 不能超过 ", 1, " 个字符长.\n当前输入了 ", 2, " 个字符"]
			],
		equalto:	[
			[0, " must be equal to ", 1]
			],
		number:		[
			[0, " 输入的数字无效", ",该数字必须在", 1, "和", 2, "之间"]
			],
		smallIntType:[
			[0,"输入的不是数字，请确认！"],
			[0,"输入的长度不能超过 ", 1]
		],	
		numeric:	[
			[0, " 只允许输入数字" ],
			[0, " 至少输入", 1, "位数字"]
			],
		alnum:		[
			["The data you entered, \"", 0, "\", does not match the requested format for ", 1,  
			"\nMinimum Length: ", 2,
			"\nCase: ", 3,
			"\nNumbers allowed: ", 4,
			"\nSpaces allowed: ", 5,
			"\nPunctuation characters allowed: ", 6, "\n"]
			],
		decimal:	[
			[0, " 输入的值无效，长度不能超过 ", 1,' 小数位数不能超过 ',2 ]
			],
		decimalr:	[
			[0, " is not a valid. Please re-enter."]
			],
		ip:		[
			[" 请给 ", 0, " 字段输入一个有效的IP地址"],
			[0, "\n输入的端口号, ", 1, ",  超出范围.\n端口号必须在 ", 2, " 和 ", 3, "之间"]
			],
		ssn:		[
			["You need to enter a valid Social Security Number.\nYour SSN must be entered in 'XXX-XX-XXXX' format."]
			],
		money:		[
			[0, " does not match the required format of ", 1]
			],
		cc:			[
			["The ", 0, " you entered is not valid. Please check again and re-enter."]
			],
		ccDate:		[
			["You credit card has expired! Please use a different card."]
			],
		zip:		[
			["Please enter a valid 5 or 9 digit Zip code."]
			],
		phone:		[
			["Please enter a valid phone number plus Area Code."],
			["Please enter a valid phone number - seven or ten digits."]
			],
		email:		[
			[0, " 不是一个有效的email地址"]
			],
		url:		[
			[0, " 不是一个有效的url"]
			],
		date:		[
			[0, "  日期格式错误!\n请输入正确的日期格式: ", 1],
			["Date must be before ", 0],
			["Date must be on or before ", 0],
			["Date must be after ", 0],
			["Date must be on or after ", 0]
			],
		select:		[
			["Please select a valid option for ", 0]
			],
		selectm:	[
			["Please select between ", 0, " and ", 1, " options for ", 2, ".\nYou currently have ", 3, " selected"]
			],
		selecti:	[
			["Please select a valid option for ", 0]
			],
		checkbox:	[
			["Please check ", 0, " before continuing"],
			["Please select between ", 0, " and ", 1, " options for ", 2, ".\nYou currently have ", 3, " selected"]
			],
		radio:		[
			["Please check ", 0, " before continuing"],
			["Please select an option for ", 0 ]
			],
		comparison:	[
			[0, " must be ", 1, " ", 2]
			],
		eitheror:	[
			["One and only one of the following fields must be entered:\n\t-", 0, "\n"]
			],
		atleast:	[
			["At least ", 0, " of the following fields must be entered:\n\t-", 1, "\n\nYou have only ", 2, " filled in.\n"]
			],
		allornone:	[
			["All or none of the following fields must be entered and accurate:\n\t-", 0, "\nYou have only ", 1, " accurate field entered.\n"]
			],
		file:		[
			["The file must be one of the following types:\n", 0, "\nNote: File extension may be case-sensitive."]
			],
		custom:		[
			[0, " is invalid."]
			],
		cazip:		[
			["Please enter a valid postal code."]
			],
		ukpost:		[
			["Please enter a valid postcode."]
			],
		germanpost:	[
			["Please enter a valid postcode."]
			],
		swisspost:	[
			["Please enter a valid postcode."]
			]
	},

	comparison:
	{
		gt:		"greater than",
		lt:		"less than",
		gte:	"greater than or equal to",
		lte:	"less than or equal to",
		eq:		"equal to",
		neq:	"not equal to"
	},

	//	Developer assist errors
	devErrors:
	{
		number:		["The lower-bound (", 0, ") is greater than the upper-bound (", 1, ") on this element: ", 2],
		length:		["The minimum length (", 0, ") is greater than the maxiumum legnth (", 1, ") on this element: ", 2],
		cc:			["Credit Card type (", 0, ") not found."],

		lines:		["! WARNING ! -- fValidate developer-assist error\n", "\nIf you are not the developer, please contact the website administrator regarding this error."],
		paramError: ["You must include the '", 0, "' parameter for the '", 1, "' validator type on this field: ", 2],
		notFound:	["The validator '", 0, "' was not found.\nRequested by: ", 1],
		noLabel:	["No element found for label: ", 0],
		noBox:		["An element with the requested id '", 0, "' was not found for the 'boxError' config value."],
		missingName:["The hidden input calling the following logical validator must have a valid name\nattribute when used in conjunction with the 'box' error-type.\n\t", 0],
		mismatch:	["Validator/Element type mismatch.\n\nElement: ", 0, "\nElement type: ", 1, "\nType required by validator: ", 2],
		noCCType:	["You must include a SELECT item with Credit Card type choices!"]
	},

	//	Config values
	config :
	{
		confirmMsg :		"Your data is about to be sent.\nPlease click 'Ok' to proceed or 'Cancel' to abort.",
		confirmAbortMsg :	"Submission cancelled.  Data has not been sent."
	},

	//	Tooltip attached to Box-item errors
	boxToolTip:	"Click to target field",

	//	Message displayed at top of alert error in group mode
	groupAlert:	"The following errors occured:\n\n- ",

	//	Literal translation of the English 'or', include padding spaces.
	or:			" or "
}