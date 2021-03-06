/**
 * 公告
 */
Ext.define("Rds.panel.RdsPlatformNoticeHomeGrid",{
	extend:'Ext.grid.Panel',
	title:'公告',
	initComponent:function(){
		var me = this;
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['id','title','content','publishtime','publisher'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/notice/queryplatformnotices.do',
                params:{
                },
                reader: {
                    type: 'json',
                    root:'data',
                    totalProperty:'total'
                }
            }
		});

		me.store.load();
        me.columns = [
                      Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
	      				{text: "公告标题", dataIndex: 'title',width:140},
	      				{text: "发布时间",  dataIndex: 'publishtime',width:120},
	      				{
	      					xtype:'actioncolumn',
	      			        header:'内容',
	      			        width:100,
	      			        items: [{
	      			            icon: 'nacCore/nacCoreApp/nacApp/images/mainmenu/Pagefind.png', 
	      			            tooltip: '查阅',
	      			            text:'查阅',
	      			            title:'查阅',
//	      			            iconCls: 'Applicationviewdetail' ,
	      			            renderer : function(value) {  
	      			            	return Ext.String.format('<button>{1}<span>{0}<span></button>', '查阅', value);  
	      			            },
	      			            handler:function(view,rowIndex,colIndex,item,record){
	      			            	Rds.panel.RdsPlatformNoticeHomeGrid.showDetails(view.getStore().getAt(rowIndex)).show();
	      			            }
	      			        }],
	      			        width:80
	      			    }];

		me.callParent(arguments);
	},
	
	statics:{
		showDetails:function(record){
			var win = Ext.create("Ext.window.Window",{
				title:'查看公告',
				width:800,
				height:400,
				layout:'border',
				items:[]
			});
			
		    //呈现组件 
			var mypanel = new Ext.Panel({ 
				id: "mypanel", 
				width: 300, 
				region:'center',
				autoScroll:true,
				renderTo: Ext.getBody() 
			}); 
		         
		    //创建模板 
			var tp1 = new Ext.XTemplate( 
					'<div align="center"><h2>{title}</h2><div>'+
				    '<div align="center">{publishtime}<div><br/><br/>'+
				    '<div align="center">{content}</div>'
			); 
		    
			//重写绑定模板 
			tp1.overwrite(mypanel.body, record.data);
			
			win.add(mypanel);
			return win;
		}
	}
});