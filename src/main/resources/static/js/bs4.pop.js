let bs4pop = {};

(function(pop){

	pop.dialog = function(opts){

		opts = $.extend( true, {
			id: '',//'#xxx'锛屽璇濇ID锛�
			title: '',
			content: '', //鍙互鏄� string銆乪lement锛�$object
			className: '', //鑷畾涔夋牱寮�
			width: 500,
			height: '',
			target: 'body',//鍦ㄤ粈涔坉om鍐呭垱寤篸ialog

			closeBtn: true, //鏄惁鏈夊叧闂寜閽�
			hideRemove: true,//鍏抽棴鏃剁Щ闄om
			escape: true, //Esc 閫€鍑�
			autoFocus: true,//鍒濆鍖栨椂鑷姩鑾峰緱鐒︾偣
			show: true,//鏄惁鍦ㄤ竴寮€濮嬫椂灏辨樉绀哄璇濇
			backdrop: true,//妯℃€佽儗鏅� true: 鏄剧ず妯℃€侊紝false: 娌℃湁妯℃€侊紝'static': 鏄剧ず妯℃€侊紝鍗曞嚮妯℃€佷笉鍏抽棴瀵硅瘽妗�
			btns: [], //footer鎸夐挳 [{label: 'Button',	className: 'btn-primary',onClick(cb){}}]
			drag: true,//鏄惁鍚敤鎷栨嫿

			onShowStart(){},
			onShowEnd(){},
			onHideStart(){},
			onHideEnd(){},
			onClose(){},
			onDragStart(){},
			onDragEnd(){},
			onDrag(){}
		}, opts);

		//寰楀埌 $el
		let $el = opts.id !== '' ? $('#'+opts.id) : undefined;
		if(!$el || !$el.length){
			$el = $(`
				<div class="modal fade" tabindex="-1" role="dialog" data-backdrop="${opts.backdrop}">
					<div class="modal-dialog ">
						<div class="modal-content">
							<div class="modal-body"></div>
						</div>
					</div>
				</div>
			`);
		}

		//寰楀埌 $body
		let $body = $el.find('.modal-body');

		//鍒涘缓 header
		if(opts.closeBtn || opts.title){

			let $header = $('<div class="modal-header"></div>');

			if(opts.title){
				$header.append(`<h5 class="modal-title"> ${opts.title} </h5>`);
			}

			if(opts.closeBtn){
				$header.append(`
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				`);
			}

			$body.before($header);

		}

		//鍒涘缓 footer
		if(opts.btns.length){

			let $footer = $('<div class="modal-footer"></div>');
			opts.btns.forEach(btn => {

				btn = $.extend(true, {
					label: 'Button',
					className: 'btn-primary',
					onClick(cb){},
				}, btn);

				let $btn = $('<button type="button" class="btn '+btn.className+' pl-5 pr-5">'+btn.label+'</button>');

				$btn.on('click', evt => {

					//鎻愪緵鎵嬪姩鍏抽棴瀵硅瘽妗嗙殑鏂规硶锛屼互渚夸簬瀵硅瘽妗嗗欢杩熷叧闂�
					evt.hide = ()=>{
						$el.modal('hide');
					};

					//濡傛灉杩斿洖涓嶆槸false灏辫嚜鍔ㄩ殣钘廳ialog
					if(btn.onClick(evt) !== false){
						$el.modal('hide');
					}

				});

				$footer.append($btn);

			});

			$body.after($footer);

		}

		//鍒涘缓鍐呭
		if(typeof opts.content === 'string'){
			$body.html(opts.content);
		}else if(typeof opts.content === 'object'){
			$body.empty();
			$(opts.content).contents().appendTo($body);//绉诲姩dom鍒� modal-body涓�
		}

		//璁剧疆灞炴€�
		opts.id && $el.attr('id', opts.id);
		opts.className && $el.addClass(opts.className);
		opts.width && $el.find('.modal-dialog').width(opts.width).css('max-width', opts.width);
		opts.height && $el.find('.modal-dialog').height(opts.height);
		opts.isCenter && $el.find('.modal-dialog').addClass('modal-dialog-centered');//瀵硅瘽妗嗗睆骞曞眳涓�

		//缁戝畾浜嬩欢
		opts.hideRemove && $el.on('hidden.bs.modal',  function(){
			$el.modal('dispose').remove();//绉婚櫎dom
		});
		$el.on('show.bs.modal', opts.onShowStart);
		$el.on('shown.bs.modal', opts.onShowEnd);
		$el.on('hide.bs.modal', opts.onHideStart);
		$el.on('hidden.bs.modal', opts.onHideEnd);
		opts.closeBtn && $el.find('.close').on('click', function(){
			return opts.onClose();
		});

		//鎷栨嫿
		if(opts.drag){
			$el.attr('data-drag', 'drag');
			drag({
				el: $el.find('.modal-content'),
				handle: $el.find('.modal-header'),
				onDragStart(){
					$el.attr('data-drag', 'draged');
					opts.onDragStart();
				},
				onDragEnd(){
					opts.onDragEnd();
				},
				onDraging(){
					opts.onDrag();
				}
			});
		}

		$(opts.target).append($el);

		$el.modal({
			backdrop: opts.backdrop, //boolean or the string 'static'.Includes a modal-backdrop element. Alternatively, specify static for a backdrop which doesn't close the modal on click.
			keyboard: opts.escape, //Closes the modal when escape key is pressed
			focus: opts.autoFocus, //Puts the focus on the modal when initialized.
			show: opts.show //Shows the modal when initialized.
		});

		let result = {
			$el: $el,
			show(){
				$el.modal('show');
			},
			hide(){
				$el.modal('hide');
			},
			toggle(){
				$el.modal('toggle');
			},
			destory(){
				$el.modal('dispose');
			}
		};

		return result;
	
	};

	pop.removeAll = function(){
		$('[role="dialog"],.modal-backdrop').remove();
	};

	//鎷栨嫿
	function drag(opts){

		opts = $.extend(true, {
			el: '',
			handle: '',
			onDragStart(){},
			onDraging(){},
			onDragEnd(){}

		}, opts);

		opts.el = $(opts.el);
		opts.handle = $(opts.handle);
		let $root = $(document);
		let isFirstDrag = true;

		$(opts.handle).on('touchstart mousedown', startEvt=>{

			startEvt.preventDefault();

			let pointEvt = startEvt;
			if(startEvt.type === 'touchstart'){
				pointEvt = startEvt.touches[0];
			}

			let startData = {
				pageX: pointEvt.pageX,
				pageY: pointEvt.pageY,
				targetPageX: opts.el.offset().left, //褰撳墠dom鐨勪綅缃俊鎭�
				targetPageY: opts.el.offset().top,
			};

			let move = moveEvt => {

				let pointEvt = moveEvt;
				if(moveEvt.type === 'touchmove'){
					pointEvt = moveEvt.touches[0];
				}

				let moveData = {
					pageX: pointEvt.pageX, //瀵逛簬鏁翠釜椤甸潰鏉ヨ锛屽寘鎷簡琚嵎鍘荤殑body閮ㄥ垎鐨勯暱搴�
					pageY: pointEvt.pageY,
					moveX: pointEvt.pageX - startData.pageX,
					moveY: pointEvt.pageY - startData.pageY,
				};

				if(isFirstDrag){
					opts.onDragStart(startData);
					isFirstDrag = false;
				}else{
					opts.onDraging();
				}

				opts.el.css({
					left: startData.targetPageX + moveData.moveX,
					top: startData.targetPageY + moveData.moveY,
				});

			};

			let up = () =>{
				$root.off('touchmove mousemove', move);
				$root.off('touchend mouseup', up);
				opts.onDragEnd();
			};

			$root.on('touchmove mousemove', move).on('touchend mouseup', up);

		});

	}

})(bs4pop);


(function(pop){

	//瀵硅瘽妗�
	pop.alert = function(content, cb, opts){

		let dialogOpts = $.extend(true, {
			title: '瀵硅瘽妗�',
			content: content,
			hideRemove: true,
			width: 500,
			btns: [
				{
					label: '纭畾',
					onClick(){
						if(cb){
							return cb();
						}
					}
				}
			]
		}, opts);

		return pop.dialog(dialogOpts);

	};

	//纭妗�
	pop.confirm = function(content, cb, opts){

		let dialogOpts = $.extend(true, {
			title: '閫夋嫨妗�',
			content: content,
			hideRemove: true,
			btns: [
				{
					label: '纭畾',
					onClick(){
						if(cb){
							return cb(true);
						}
					}
				},
				{
					label: '鍙栨秷',
					className: 'btn-default',
					onClick(){
						if(cb){
							return cb(false);
						}
					}
				}
			]
		}, opts);

		return this.dialog(dialogOpts);

	};

	//杈撳叆妗�
	pop.prompt = function(content, value, cb, opts){
		
		let $content = $(`
			<div>
				<p>${content}</p>
				<input type="text" class="form-control" value="${value}"/>
			</div>
		`);

		let $input = $content.find('input');

		let dialogOpts = $.extend(true, {
			title: '杈撳叆妗�',
			content: $content,
			hideRemove: true,
			width: 500,
			btns: [
				{
					label: '纭畾',
					onClick(){
						if(cb){
							return cb(true, $input.val());
						}
					}
				},
				{
					label: '鍙栨秷',
					className: 'btn-default',
					onClick(){
						if(cb){
							return cb(false, $input.val());
						}
					}
				}
			]
		}, opts);

		return pop.dialog(dialogOpts);

	};

	// 娑堟伅妗�
	pop.notice = function(content, opts){

		opts = $.extend( true, {

			type: 'primary', //primary, secondary, success, danger, warning, info, light, dark
			position: 'topcenter', //topleft, topcenter, topright, bottomleft, bottomcenter, bottonright, center,
			appendType: 'append', //append, prepend
			closeBtn: false,
			autoClose: 2000,
			className: '',

		}, opts);

		// 寰楀埌瀹瑰櫒 $container
		let $container = $('#alert-container-'+ opts.position);
		if(!$container.length){
			$container = $('<div id="alert-container-' + opts.position + '" class="alert-container"></div>');
			$('body').append($container);
		}

		// alert $el
		let $el = $(`
			<div class="alert fade alert-${opts.type}" role="alert">${content}</div>
		`);

		// 鍏抽棴鎸夐挳
		if(opts.autoClose){
			$el
				.append(`
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				`)
				.addClass('alert-dismissible');
		}

		//瀹氭椂鍏抽棴
		if(opts.autoClose){

			let t = setTimeout(() => {
				$el.alert('close');
			}, opts.autoClose);

		}

		opts.appendType === 'append' ? $container.append($el) : $container.prepend($el);

		setTimeout(() => {
			$el.addClass('show');
		}, 50);
		
		return;

	};

})(bs4pop);



if( typeof module === "object" && typeof module.exports === "object" ){
	module.exports = bs4pop
}