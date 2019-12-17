/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// https://ckeditor.com/docs/ckeditor4/latest/api/CKEDITOR_config.html

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' },
		{ name: 'about' }
	];

	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';
config.extraPlugins = 'smiley';
               config.smiley_columns = 6;
// This is actually the default value.
config.smiley_images = [
    'regular_smile.png','sad_smile.png','wink_smile.png','teeth_smile.png','confused_smile.png','tongue_smile.png',
    'embarrassed_smile.png','omg_smile.png','whatchutalkingabout_smile.png','angry_smile.png','angel_smile.png','shades_smile.png',
    'devil_smile.png','cry_smile.png','lightbulb.png','thumbs_down.png','thumbs_up.png','heart.png',
    'broken_heart.png','kiss.png','envelope.png'
];
config.smiley_path = '/bbs/statics/ckeditor4/plugins/smiley/images/';
// Use textual emoticons as description.
config.smiley_descriptions = [
    ':)', ':(', ';)', ':D', ':/', ':P', ':*)', ':-o',
    ':|', '>:(', 'o:)', '8-)', '>:-)', ';(', '', '', '',
    '', '', ':-*', ''
];
	config.image_previewText=' ';//这是默认预览内容，我们将系统默认预览内容清空即可
	config.filebrowserImageUploadUrl = "/bbs/root/uploadSource";
};
