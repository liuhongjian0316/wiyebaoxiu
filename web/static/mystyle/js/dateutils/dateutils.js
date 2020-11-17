
/**
 * 将date类型转换成format所需
 * @param Date 日期
 * @param format  所需格式
 *
 *
 */
Format ={};
Format.dateFormat = function(d,format){
    if(d == ''){
        format ="";
    }else{
        var date = {
            "M+": d.getMonth() + 1,
            "D+": d.getDate(),
            "h+": d.getHours(),
            "m+": d.getMinutes(),
            "s+": d.getSeconds()
        };
        if (/(Y+)/i.test(format)) {
            format = format.replace(RegExp.$1, (d.getFullYear() + '').substr(4 - RegExp.$1.length));
        }
        for (var k in date) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1
                    ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
            }
        }
    }
    return format;
}

/**
 * 将数据
 * "YYYYMMDDHHMMSS"转换为日期格式“YYYY-MM-DD HH:MM:SS”
 * render
 *
 */
Format.dateTimeToDateTimeStr=function(value) {
    var returnStr='';
    if(value!='undefined'&&value!=''){
        if(value.length==14){
            returnStr=Format.dateTimeToDateStr(value)+" "+Format.dateTimeToTimeStr(value);
        }else{
            returnStr=value;
        }
    }else{
        returnStr='';
    }
    return returnStr;
}


/**
 * 将数据
 * "YYYYMMDD"或"YYYYMMDDHHMMSS"转换为
 * 日期格式“YYYY-MM-DD”
 * render
 *
 */
Format.dateTimeToDateStr=function(value) {
    var returnStr='';
    if(value!='undefined'&&value!=''){
        if(value.length==8||value.length==14){
            returnStr=value.substring(0,4)+"-"+value.substring(4,6)+"-"+value.substring(6,8)
        }else{
            returnStr=value;
        }
    }else{
        returnStr='';
    }
    return returnStr;
}

/**
 * 将数据
 * "YYYYMMDDHHMMSS"转换为日期格式“HH:MM:SS”
 * render
 *
 */
Format.dateTimeToTimeStr=function(value) {
    var returnStr='';
    if(value!='undefined'&&value!=''){
        if(value.length==14){
            returnStr=value.substring(8,10)+":"+value.substring(10,12)+":"+value.substring(12,14)
        }else{
            returnStr=value;
        }
    }else{
        returnStr='';
    }
    return returnStr;
}
Format.getBeforeDate = function(num) {
    var date1 = new Date();
    //今天时间
    var time1 = date1.getFullYear() + "-" + (date1.getMonth() + 1) + "-" + date1.getDate()+" "
        +date1.getHours()+":"+date1.getMinutes()+":"+date1.getSeconds();

    var date2 = new Date(date1);
    date2.setDate(date1.getDate() + num);
    //num是正数表示之后的时间，num负数表示之前的时间，0表示今天
    var time2 = date2.getFullYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDate()+" "
        +date2.getHours()+":"+date2.getMinutes()+":"+date2.getSeconds();

    var date3= new Date(time2);
    return date3;
}