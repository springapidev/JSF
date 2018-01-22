// FNC for detecting for click outside of any elements ============== 
$.fn.clickOff = function(callback, selfDestroy) {
		var clicked = false;
		var parent = this;
		var destroy = selfDestroy || true;
		
		parent.click(function() {
			clicked = true;
		});
		
		$(document).click(function(event) { 
			if (!clicked) {
				callback(parent, event);
			}
			if (destroy) {
			};
			clicked = false;
		});
	};
	
/** 
 * PrimeFaces Volt Layout
 */
var Volt = {
  
    init: function() {
        this.menuWrapper = $('#layout-menu-cover');
        this.menu = this.menuWrapper.find('ul.layout-menu');
        this.menulinks = this.menu.find('a.menulink');
        this.menuButton = $('#menu-button');
        this.expandedMenuitems = this.expandedMenuitems||[];
        
        this.bindEvents();
    },
    
    bindEvents: function() {
        var $this = this;
        
        this.menuButton.on('click',function() {
            $this.menuButtonClick = true;
            
            if($this.menuWrapper.hasClass('active-menu')){
                $this.menuButton.removeClass('active-menu');
                $this.menuWrapper.removeClass('active-menu');
            }
            else{
                $this.menuButton.addClass('active-menu');
                $this.menuWrapper.addClass('active-menu');
            }
        });
       
        this.menulinks.on('click',function(e) {
            var menuitemLink = $(this),
            menuitem = menuitemLink.parent();
            
            if(menuitem.hasClass('active-menu-parent')) {
                menuitem.removeClass('active-menu-parent');
                menuitemLink.removeClass('active-menu').next('ul').removeClass('active-menu');
                $this.removeMenuitem(menuitem.attr('id'));
            }
            else {
                var activeSibling = menuitem.siblings('.active-menu-parent');
                if(activeSibling.length) {
                    activeSibling.removeClass('active-menu-parent');
                    $this.removeMenuitem(activeSibling.attr('id'));

                    activeSibling.find('ul.active-menu,a.active-menu').removeClass('active-menu');
                    activeSibling.find('li.active-menu-parent').each(function() {
                        var menuitem = $(this);
                        menuitem.removeClass('active-menu-parent');
                        $this.removeMenuitem(menuitem.attr('id'));
                    });
                }

                menuitem.addClass('active-menu-parent');
                menuitemLink.addClass('active-menu').next('ul').addClass('active-menu');
                $this.addMenuitem(menuitem.attr('id'));
            }

            if(menuitemLink.next().is('ul')) {
                e.preventDefault();
            }
            else {
                $this.menuButton.removeClass('active-menu');
                $this.menuWrapper.removeClass('active-menu');
            }

            $this.saveMenuState();
        })
        .clickOff(function(e) {
            if($this.menuButtonClick) {
                $this.menuButtonClick = false;
            } else {
                $this.menuButton.removeClass('active-menu');
                $this.menuWrapper.removeClass('active-menu');
            }
        });
    },
    
    removeMenuitem: function(id) {        
        this.expandedMenuitems = $.grep(this.expandedMenuitems, function(value) {
            return value !== id;
        });
    },
    
    addMenuitem: function(id) {
        if($.inArray(id, this.expandedMenuitems) === -1) {
            this.expandedMenuitems.push(id);
        }
    },
    
    saveMenuState: function() {
        $.cookie('volt_expandeditems', this.expandedMenuitems.join(','), {path:'/'});
    },
    
    clearMenuState: function() {
        $.removeCookie('volt_expandeditems', {path:'/'});
    },
    
    restoreMenuState: function() {
        var menucookie = $.cookie('volt_expandeditems');
        if(menucookie) {
            this.expandedMenuitems = menucookie.split(',');
            for(var i = 0; i < this.expandedMenuitems.length; i++) {
                var id = this.expandedMenuitems[i];
                if(id) {
                    var menuitem = $("#" + this.expandedMenuitems[i].replace(/:/g,"\\:"));
                    menuitem.addClass('active-menu-parent');
                    menuitem.children('a,ul').addClass('active-menu');
                }             
            }
        }
    },
    
    isMobile: function() {
        return (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(window.navigator.userAgent));
    }
};

$(function() {
   Volt.init();
});