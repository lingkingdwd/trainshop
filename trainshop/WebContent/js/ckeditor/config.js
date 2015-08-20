/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	config.language = 'zh-cn';
	config.width = 500;
	config.height = 600;
	//config.uiColor = '#AADC6E';
	// 图片上传配置  
    config.filebrowserUploadUrl = basePath + 'fileUpload/upload?type=File';  
    config.filebrowserImageUploadUrl = basePath + 'fileUpload/upload?type=Image';  
    config.filebrowserFlashUploadUrl = basePath + 'fileUpload/upload?type=Flash';  
      
    // 图片浏览配置  
    config.filebrowserImageBrowseUrl = basePath + 'browerServer/brower?type=image';
};
