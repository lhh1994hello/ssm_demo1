//下拉框数据
var initdata = [ "Java", "JavaScript", "C++", "C#", "Python", "PHP" ];
// 选中数据
var selectedData = [ "Java", "PHP" ];
$(function() {
	console.log("测试select2插件");
	// 初始化select2单选
	initSelect2WithSearch();

	// 初始化select2多选（没有选中项）
	initSelect2();

	// 初始化select2多选（包含选中项）
	select2WithData(selectedData);
	select2WithTest();
})

/**
 * 初始化select2单选，默认带搜索功能。
 */
function initSelect2WithSearch() {
	$("#sel_menu").select2({
		tags : true,
		placeholder : '请搜索或选择语言',
		data : initdata,
		allowClear : true
	});
}

/**
 * 初始化select2多选（没有选中项）
 */
function initSelect2() {
	$("#sel_menu2").select2({
		tags : true,
		maximumSelectionLength : 5,
		placeholder : '请添加或选择语言',
		multiple : true,
		maximumInputLength : 10,// 允许长度
		data : initdata,
	});
}

/**
 * 初始化select2多选（包含选中项）
 */
function select2WithData(selectedData) {
	$("#sel_menu3").select2({
		tags : true, // 支持新增，默认为false
		maximumSelectionLength : 6, // 最多能够选择的个数
		multiple : true, // 支持多选，默认为false
		data : initdata, // 下拉框绑定的数据
		allowClear : true, // 支持清空，默认为false
		placeholder : '请添加或选择语言' // 提示语
	}).val(selectedData).trigger('change'); // 多选情况下给选中项的赋值
}

function select2WithTest() {
	$("#sel_menu4").select2();
}

/**
 * 获取多选框选中项的值
 */
function getSelectedData() {
	var mulSelData = $("#sel_menu3").val().join(",");// 获取多选输入框选中值的方式
	alert("sel_menu3的选中项是：" + mulSelData);
}