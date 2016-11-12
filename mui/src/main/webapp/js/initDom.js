var GB = {
	init: function(){
		var height = $(window).height();
		return height;
	},
	/* 倒计时 */
	getStart: function($this) {
		var //date = new Date(parseInt($this.attr("time"), 10) || 0),
			//day = date.getDate() || 0,
			//hour = date.getHours() || 0,
			//minute = date.getMinutes() || 0,
			//second = date.getSeconds() || 0,
			date = parseInt($this.attr("time"), 10) || 0,
			day = Math.floor(date / 86400) || 0,
			hour = Math.floor((date % 86400)/3600) || 0,
			minute = Math.floor(((date % 86400)%3600)/60) || 0,
			second = ((date % 86400)%3600)%60 || 0,
			move = "";
		/*$this.find(".time-d").text(day);
		$this.find(".time-h").text(hour);
		$this.find(".time-m").text(minute);
		$this.find(".time-s").text(second);*/
		$(".item-b-l-time").text(hour+"小时"+minute+"分钟");
		move = setTimeout(function(){GB.timeAuto($this, move, day, hour, minute, second);}, 1000);
	},
	timeAuto: function($this, move, day, hour, minute, second) {
		second--;
		if(second === 0 && minute === 0 && hour === 0 && day === 0){
			clearTimeout(move);
		}
		if(second < 0) {
			minute--;
			second = 59;
			if(minute < 0) {
				hour--;
				minute = 59;
				if(hour < 0) {
					day--;
					hour = 23;
				}
			}
		}
		/*$this.find(".time-d").text(day);
		$this.find(".time-h").text(hour);
		$this.find(".time-m").text(minute);
		$this.find(".time-s").text(second);*/
		$(".item-b-l-time").text(hour+"小时"+minute+"分钟");
		console.log(day, hour, minute, second);
		move = setTimeout(function(){GB.timeAuto($this, move, day, hour, minute, second);}, 1000);
	}
}

	