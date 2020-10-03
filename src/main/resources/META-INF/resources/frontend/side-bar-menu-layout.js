import {PolymerElement,html} from '@polymer/polymer/polymer-element.js';

class SideBarMenuLayout extends PolymerElement {

    static get template() {
        return html`
        	<style>
        		:host{
        			
        			width: 100%;
        			transition: left .9s;
					position: absolute;
					height:100%;
					background-color: white;
					z-index: 1;
					margin: 0 !important;
					
		 
				}
				#side-bar-menu-header{ 
					 
					align-items: center;
				    width: 100%;
				    white-space: nowrap; 
				    padding: 1em;
				    
				}  
				.spacer{ 
					
					flex-grow:1;
				}
				.fadeout{
        			opacity: 0;
					animation-name: fade-out;
				  	animation-duration: .54s;
				}
				.fadein {
					opacity: 1;
					animation-name: fade-in;
				  	animation-duration: .54s;
				}
				@keyframes fade-out {
				  from {opacity: 1;
				  }
				  to {opacity: 0}
				}
				
				@keyframes fade-in {
				  from {opacity: 0;
				  }
				  to {opacity: 1;}
				}
				
				#side-bar-opener{
					position: absolute;
				}
				
				.app-header{
	
        			width: 100%;
					background-color: #f4f7f8;
					
				}
				.app-header vaadin-button{
	
				    font-size: 25px;
				    width: 55px;
				    height: 55px;
					
				}
				
				.row-item{

					border-bottom: #e2e2e2 1px solid;
				    align-items: baseline;
				    margin: 0;
				    padding: .5em;
				    width: 100%;

				}
				
				#application-name{
					display: flex;
					justify-content: center;
					flex-grow: 1;
				}
       
								        	
        	</style>
            <vaadin-vertical-layout id='main-layout'>
            	<vaadin-vertical-layout class='app-header'>
            		<vaadin-horizontal-layout id='side-bar-menu-header'>
            			<div id='application-name'><slot name="appName"></slot></div>
        				<vaadin-button id='side-bar-opener' on-click='_onOpen'></vaadin-button>
            			<vaadin-button id='side-bar-closer' on-click='_onClose'></vaadin-button>
            		</vaadin-horizontal-layout>
            	</vaadin-vertical-layout>
            	<vaadin-vertical-layout id='content'> 
            	</vaadin-vertical-layout>
           
            </vaadin-vertical-layout>`;
    }
    
    ready() {
        super.ready();
        console.log("calculated width of component is " + this.offsetWidth);
        
       // this.$['side-bar-closer'].style.display = "none";
        this._close(); 
        window.addEventListener("resize", this._onResize.bind(this));
    }
    
    _onResize(){
    	
    	this._close();
    	
    }
    
    _onClose(){
    	console.log("close clicked");
    	this._close();
    }
    
    _onOpen(){
    	console.log("open clicked");
    	this._open();
    	
    }
    
    _close(){
    	this.style.left = -this.offsetWidth + "px";
    	//var buttonStyle = window.getComputedStyle(this.$['side-bar-opener']);
    	var buttonWidth = (37 + 9); //this.$['side-bar-opener'].offsetWidth
    	console.log("button width is " + this.$['side-bar-opener'].offsetWidth);
    	
    	this.$['side-bar-opener'].style.right = "calc(-1em - " + buttonWidth + "px)";
    	this.$['side-bar-opener'].classList.add("fadein");
    	this.$['side-bar-opener'].classList.remove("fadeout");
    	this.$['side-bar-closer'].classList.add("fadeout");
    	this.$['side-bar-closer'].classList.remove("fadein");
 
    	
    }
    
    _open(){
    	this.style.left = "0px";
    	this.$['side-bar-closer'].style.display = "block";
    	this.$['side-bar-opener'].classList.add("fadeout");
    	this.$['side-bar-opener'].classList.remove("fadein");
    	this.$['side-bar-closer'].classList.add("fadein");
    	this.$['side-bar-closer'].classList.remove("fadeout");
 
    }

    static get is() {
          return 'side-bar-menu-layout'; 
    }
}

customElements.define(SideBarMenuLayout.is, SideBarMenuLayout);