package com.mcms.sfw.common.util;

import com.mcms.sfw.sys.model.SysPri;

import java.util.List;

/**
 * Created by Administrator on 2014/5/8.
 */
public class ViewUtil {
    public static String getLoginUserMenuHtml(List<SysPri> menu) {
        String html="";
        if(null!= menu){
            for(int i =0;i<menu.size();i++){
                String icon ="icon-folder-close";
                if(!StringUtil.isNullString(menu.get(i).getICON_BOOTSTRAP())){
                    icon=menu.get(i).getICON_BOOTSTRAP();
                }
                String html_click="onclick=\"setContentByMenu('menu_"+menu.get(i).getID()+"','"+menu.get(i).getURL()+"');\"";
                if(null==menu.get(i).getChildren()||menu.get(i).getChildren().size()<1){
                    html+="<li> <a id='menu_"+menu.get(i).getID()+"' href='#' "+html_click+"><i class='icon "+icon+"'></i> <span>"+menu.get(i).getNAME()+"</span></a></li>\n";
                }else{
                    html+="<li  class='submenu' > <a  id='menu_"+menu.get(i).getID()+"' href='#' "+html_click+"><i class='icon "+icon+"'></i> <span>"+menu.get(i).getNAME()+"</span><span class='label label-important'>"+menu.get(i).getChildren().size()+"</span></a>\n" ;
                    html+="<ul>\n";
                    html+= ViewUtil.getLoginUserMenuHtml(menu.get(i).getChildren());
                    html+="</ul>\n" ;
                    html+="</li>\n";
                }
            }
        }
        return html;
    }
}
