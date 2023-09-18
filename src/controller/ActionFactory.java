package controller;

import admin.controller.action.AdminIndexAction;
import admin.controller.action.AdminMemberDeleteAction;
import admin.controller.action.AdminMemberListAction;
import admin.controller.action.AdminNoticeDeleteAction;
import admin.controller.action.AdminNoticeListAction;
import admin.controller.action.AdminNoticeUpdateAction;
import admin.controller.action.AdminNoticeUpdateFormAction;
import admin.controller.action.AdminNoticeViewAction;
import admin.controller.action.AdminNoticeWriteAction;
import admin.controller.action.AdminNoticeWriteFormAction;
import admin.controller.action.AdminOrderDeleteAction;
import admin.controller.action.AdminOrderListAction;
import admin.controller.action.AdminOrderTrackingUpdateAction;
import admin.controller.action.AdminQnaDeleteAction;
import admin.controller.action.AdminQnaDetailAction;
import admin.controller.action.AdminQnaListAction;
import admin.controller.action.AdminQnaRepUpdateAction;
import admin.controller.action.AdminQnaRepUpdateFormAction;
import admin.controller.action.AdminQnaResaveAction;
import controller.action.Action;
import controller.action.NoticeListAction;
import controller.action.NoticeSearchAction;
import controller.action.NoticeViewAction;
import controller.action.OrderDeleteAction;
import controller.action.QnaDeleteAction;
import controller.action.QnaListAction;
import controller.action.QnaViewAction;
import controller.action.QnaWriteAction;
import controller.action.QnaWriteFormAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		if (command.equals("notice_list")) {
			action = new NoticeListAction();
		} else if (command.equals("notice_view")) {
			action = new NoticeViewAction();
		}else if (command.equals("notice_search")) {
			action = new NoticeSearchAction();
		}else if (command.equals("admin_login_form")) {
			action = new AdminIndexAction();
//		} else if (command.equals("admin_login")) {
//			action = new AdminLoginAction();
//		} else if (command.equals("admin_logout")) {
//			action = new AdminLogoutAction();
		} else if (command.equals("admin_notice_list")) {
			action = new AdminNoticeListAction();
		} else if (command.equals("admin_notice_write_form")) {
			action = new AdminNoticeWriteFormAction();
		} else if (command.equals("admin_notice_write")) {
			action = new AdminNoticeWriteAction();
		} else if (command.equals("admin_notice_view")) {
			action = new AdminNoticeViewAction();
//		} else if (command.equals("admin_notice_check_pass_form")) {
//			action = new AdminNoticeCheckPassFormAction();
//		} else if (command.equals("admin_notice_check_pass")) {
//			action = new AdminNoticeCheckPassAction();
		}else if(command.equals("admin_notice_update_form")){
			action = new AdminNoticeUpdateFormAction();
		}else if(command.equals("admin_notice_update")){
			action = new AdminNoticeUpdateAction();
		} else if (command.equals("admin_notice_delete")) {
			action = new AdminNoticeDeleteAction();
		} else if (command.equals("admin_member_list")) {
			action = new AdminMemberListAction();
		} else if (command.equals("admin_member_delete")) {
			action = new AdminMemberDeleteAction();
		}else if (command.equals("admin_member_view")) {
			action = new AdminMemberViewAction();
		} else if (command.equals("qna_list")) {
			action = new QnaListAction();
		} else if (command.equals("qna_write_form")) {
			action = new QnaWriteFormAction();
		} else if (command.equals("qna_write")) {
			action = new QnaWriteAction();
		} else if (command.equals("qna_view")) {
			action = new QnaViewAction();
		}else if (command.equals("qna_delete")) {
			action = new QnaDeleteAction();
		} else if (command.equals("admin_qna_list")) {
			action = new AdminQnaListAction();
		} else if (command.equals("admin_qna_detail")) {
			action = new AdminQnaDetailAction();
		} else if (command.equals("admin_qna_repsave")) {
			action = new AdminQnaResaveAction();
		} else if (command.equals("admin_qna_repupdate_form")) {
			action = new AdminQnaRepUpdateFormAction();
		}else if (command.equals("admin_qna_repupdate")) {
			action = new AdminQnaRepUpdateAction();
		}else if (command.equals("admin_qna_delete")) {
			action = new AdminQnaDeleteAction();
		}else if (command.equals("admin_order_list")) {
			action = new AdminOrderListAction();
		}else if (command.equals("admin_order_delete")) {
			action = new AdminOrderDeleteAction();
		}else if (command.equals("order_delete")) {
			action = new OrderDeleteAction();
		}else if (command.equals("admin_order_tracking_update")) {
			action = new AdminOrderTrackingUpdateAction();
		}
		// 관리자모드
		return action;

	}
}

