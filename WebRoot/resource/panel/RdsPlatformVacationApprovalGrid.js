/**
 * 休假登记审批
 */
Ext.define("Rds.panel.RdsPlatformVacationApprovalGrid",{
	extend:'Ext.grid.Panel',
	title:'外出登记审批',
	requires:['Rds.ux.DateTimeField'],
	initComponent:function(){
		var me = this;
        var vtitle = Ext.create("Ext.form.field.Text",{
        	name : 'vtitle',
			labelWidth : 60,
			width : 200,
			fieldLabel : '休假标题'
        });
        
        var vdsc = Ext.create("Ext.form.field.Text",{
        	name : 'vdsc',
			labelWidth : 60,
			width : 200,
			fieldLabel : '休假内容'
        }); 
        
        var applytime = Ext.create("Ext.form.field.Date",{
        	name : 'applytime',
			labelWidth : 60,
			width : 200,
			format:'Y-m-d',
			fieldLabel : '申请时间'
        });  
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['id','vuser','vtitle','vdsc','vstarttime','vendtime','applytime','status','checktime','checkidea','reguser'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/vacation/queryplatformvacationspage.do',
                params:{
                },
                reader: {
                    type: 'json',
                    root:'data',
                    totalProperty:'total'
                }
            },
            listeners:{
            	beforeload:function( store, operation, eOpts ){
	        		Ext.apply(store.proxy.extraParams, {
	        			'vtitle':vtitle.getValue(),
	        			'vdsc':vdsc.getValue(),
	        			'applytime':Ext.util.Format.date(applytime.getValue(),'Y-m-d')
	        		});
	        	},
	        	load:function(){
	        		me.selModel.deselectAll();
	        	}
            }
		});
		
		me.listeners={
			'itemdblclick':function( grid, record, item, index, e, eOpts ){
//				Rds.panel.RdsPlatformNoticeHomeGrid.showDetails(record).show();
			}	
		};

		me.store.load();
        me.columns = [
                      Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
                      {text: "休假标题", dataIndex: 'vtitle',width:200},
                      {text: "休假人员", dataIndex: 'vuser',width:100},
	      			  {text: "休假内容", dataIndex: 'vdsc',width:250},
                      {text: "起始时间",  dataIndex: 'vstarttime',width:120},
                      {text: "结束时间",  dataIndex: 'vendtime',width:120},
                      {text: "登记人员",  dataIndex: 'reguser',width:80},
                      {text: "申请时间",  dataIndex: 'applytime',width:200},
                      {text: "审核时间",  dataIndex: 'checktime',width:200},
                      {text: "审核意见",  dataIndex: 'checkidea',width:200},
                      {text: "状态",  dataIndex: 'status',width:160,
                      	renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
                      		var result = "";
                      		if(value=='-1'){
                      			result = "不通过";
                      		}else if(value==0){
                      			result = "审核中";
                      		}else if(value==1){
                      			result = "审核通过";
                      		}
                      		return result;
                      	}
                      }];
        me.selModel = Ext.create('Ext.selection.CheckboxModel',{
			listeners:{
				'selectionchange':function( model, record, index, eOpts ){
					var selects = me.getView().getSelectionModel().getSelection().length;
					var tbar = me.down("toolbar");
					
					var btn_edit = tbar.down("button[name=edit]");
					
					if(selects==1){
						btn_edit.setDisabled(false);
					}else if(selects>1){
						btn_edit.setDisabled(true);
					}else if(selects<1){
						btn_edit.setDisabled(true);
					}
				}
			}
		});
        
        me.dockedItems = [{
			xtype : 'toolbar',
			name : 'menu',
			dock : 'top',
			items : [{
            	xtype:'button',
            	text:'审批',
            	iconCls:'Applicationformedit',
            	disabled:true,
            	name:'edit',
            	listeners: {
                    click: function(){
                    	var me = this.up("gridpanel");
                		var selects = me.getView().getSelectionModel().getSelection();
                		var record = selects[0];
                		var status = record.get("status");
                		if(status!=0){
                			Ext.Msg.alert('提示', "只能审核提交的申请，不能审核已经审核过的申请!"); 
                			return;
                		}
                		
                		var form = me.getNoticeForm();
                		var window = me.getWindow();
                		
                		form.loadRecord(record);
                		window.add(form);
                		window.show();
                		window.setTitle("修改登记");
                		form.down("htmleditor[name=vdsc]").setValue(record.get("vdsc"));
                		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'刷新',
            	iconCls:'Arrowrotateclockwise',
            	name:'refresh',
            	listeners: {
                    click: function() {

                    	var store = me.getStore();
                    	store.reload();
                    }
                },
                scope: me
            }]
		},{
			xtype : 'toolbar',
			name : 'search',
			dock : 'top',
			items : [{  
                xtype: 'buttongroup',  
                columns: 6,   
                floatable:true,  
                defaults: {  
                    scale: 'small'  
                },  
                items: [vtitle,vdsc,applytime,{
					xtype : 'button',
					text:'查询',
					iconCls : 'Find',
					handler:me.onSearch
				}]
			}]
		}];
        
        me.bbar = new Ext.PagingToolbar({
			pageSize : 25,  // 一页显示25行
			store : me.store,  // 前面定义的store
       	 	displayInfo : true, // 是否显示总体信息
       	 	displayMsg : "第 {0} - {1} 条  共 {2} 条",
       	 	emptyMsg : "没有符合条件的记录"
		});
		me.callParent(arguments);
	},
	
	onSearch:function(){
		var me = this.up("gridpanel");
		me.getStore().currentPage = 1;
		var store = me.getStore();
    	store.reload();
	},
	
	getNoticeForm:function(){
		var form = Ext.create("Ext.form.Panel",{
			region:'center',
			style : 'margin-left:5px;margin-right:5px;margin-top:5px;margin-bottom:5px;',
            labelAlign:"right",
            autoScroll:true,
            bodyPadding: 10,
            defaults: {
                anchor: '100%',
                labelWidth: 100
            },
            border:false,
            items: [{
                xtype: 'fieldset',
                title: '申请登记',
                //collapsible: true,
                defaults: {
                    labelWidth: 89,
                    anchor: '100%',
                    layout: {
                        type: 'hbox',
                        defaultMargins: {top: 5, right: 5, bottom: 0, left: 0}
                    }
                },
                items: [{
                	xtype:'textfield',
                	name : 'id',
        			labelWidth : 60,
        			hidden:true,
        			readOnly:true,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : 'id'
                },{
                	xtype:'textfield',
                	name : 'vuser',
        			labelWidth : 60,
        			width : 200,
        			labelAlign:'right',
        			readOnly:true,
        			value:username,
        			fieldLabel : '休假人员'
                },{
                	xtype:'textfield',
                	name : 'vtitle',
        			labelWidth : 60,
        			width : 200,
        			labelAlign:'right',
        			readOnly:true,
        			fieldLabel : '休假标题'
                },{
                	xtype:'datetimefield',
                	name : 'vstarttime',
//                	value:new Date(),
        			labelWidth : 60,
        			format: 'Y-m-d H:i:s',
        			readOnly:true,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '起始时间'
                },{
                	xtype:'datetimefield',
                	name : 'vendtime',
//                	value:new Date(),
        			labelWidth : 60,
        			format: 'Y-m-d H:i:s',
        			width : 200,
        			labelAlign:'right',
        			readOnly:true,
        			fieldLabel : '结束时间'
                },{
                	xtype:'htmleditor',
                	name : 'vdsc',
        			labelWidth : 60,
        			width : 200,
        			height:250,
        			labelAlign:'right',
        			readOnly:true,
        			fieldLabel : '休假内容'
                },{
                	xtype:'textfield',
                	name : 'reguser',
        			labelWidth : 60,
        			width : 200,
        			hidden:true,
        			labelAlign:'right',
        			value:username,
        			readOnly:true,
        			fieldLabel : '登记人员'
                }]
            },{
                xtype: 'fieldset',
                title: '审批',
                //collapsible: true,
                defaults: {
                    labelWidth: 89,
                    anchor: '100%',
                    layout: {
                        type: 'hbox',
                        defaultMargins: {top: 5, right: 5, bottom: 0, left: 0}
                    }
                },
                items: [{
                	xtype:'htmleditor',
                	name : 'checkidea',
        			labelWidth : 60,
        			width : 200,
        			labelAlign:'right',
        			height:100,
        			fieldLabel : '审核意见'
                }]
            }]
		});
		
		return form;
	},
	
	getWindow:function(){
		var me = this;
		var win = Ext.create("Ext.window.Window",{
			title:'title',
			width:475,
			height:550,
			layout:'border',
			buttons:[{
				text:'审核通过',
				handler:function(){
					var form = win.down("form");
					var checkidea = form.down("htmleditor[name=checkidea]").getValue();
					var id = form.down("textfield[name=id]").getValue();
					
					Ext.Ajax.request({
				          method:'POST',//提交的方式,如Get，post等
				          url : basepath+"platform/vacation/updateapproval.do",
				          params:{
				        	  checkidea:checkidea,
				        	  status:1,
				        	  id:id
				          },
				         success:function(reps,option){
				        	 var result = Ext.JSON.decode(reps.responseText);// 就可以取出来。如果是数组，那么很简单  
				        	 if(result.code=='10000'){
				        		 Ext.Msg.alert('提示', "保存成功！！！"); 
				        		 me.getStore().load();
				        		 win.close();
				        	 }
				        },//成功的回调函数    
				        failure:function(res){
				      
				        }//失败的情况

				    });
				}
			},{
				text:'审核不通过',
				handler:function(){
					var form = win.down("form");
					var checkidea = form.down("htmleditor[name=checkidea]").getValue();
					var id = form.down("textfield[name=id]").getValue();
					
					Ext.Ajax.request({
				          method:'POST',//提交的方式,如Get，post等
				          url : basepath+"platform/vacation/updateapproval.do",
				          params:{
				        	  checkidea:checkidea,
				        	  status:-1,
				        	  id:id
				          },
				         success:function(reps,option){
				        	 var result = Ext.JSON.decode(reps.responseText);// 就可以取出来。如果是数组，那么很简单  
				        	 if(result.code=='10000'){
				        		 Ext.Msg.alert('提示', "保存成功！！！"); 
				        		 me.getStore().load();
				        		 win.close();
				        	 }
				        },//成功的回调函数    
				        failure:function(res){
				      
				        }//失败的情况

				    }); 
				}
			},{
				text:'取消',
				handler:function(){
					win.close();
				}
			}]
		
		});
		return win;
	}
});