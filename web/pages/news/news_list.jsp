<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>BSM开发模块</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <jsp:include page="/pages/header_import.jsp"/>
    <script type="text/javascript" src="js/news_list.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <strong>新闻管理</strong>
                    </div>
                    <div class="panel-body">
                        <div id="newsDiv">
                            <table class="table table-bordered table-striped table-hover" id="newsTable">
                                <tr>
                                    <td class="text-center"><input type="checkbox" name="selall" id="selall"></td>
                                    <td class="text-center"><strong>新闻标题</strong></td>
                                    <td class="text-center"><strong>发布日期</strong></td>
                                    <td class="text-center"><strong>内容</strong></td>
                                    <td class="text-center"><strong>操作</strong></td>
                                </tr>
                            </table>
                            <button id="deleteBtn" class="btn btn-danger">删除新闻数据</button>
                            <div id="pageDiv" class="text-right">
                                <ul class="pagination pagination-sm" id="pagecontrol"></ul>
                            </div>
                            <div class="alert alert-success" id="alertDiv" style="display: none;">
                                <button class="close">&times;</button>
                                <span id="alertText"></span>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer text-center">
                        作者:XYQ
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%-- data-toggle="modal" data-target="#newsInfo"--%>
    <div class="modal" id="newsInfo">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">编辑新闻数据</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="post" id="myform">
                        <fieldset>
                            <legend><label>编辑新闻</label></legend>
                            <div class="form-group" id="snidDiv">
                                <label class="col-md-3 control-label" for="snid">标题:</label>
                                <div class="col-md-5">
                                    <span id="snid"></span>
                                </div>
                                <div class="col-md-4" id="snidSpan"></div>
                            </div>
                            <div class="form-group" id="titleDiv">
                                <label class="col-md-3 control-label" for="title">标题:</label>
                                <div class="col-md-5">
                                    <input type="text" id="title" name="title" class="form-control" placeholder="请输入新闻标题">
                                </div>
                                <div class="col-md-4" id="titleSpan"></div>
                            </div>
                            <div class="form-group" id="itemDiv">
                                <label class="col-md-3 control-label" for="item">类型:</label>
                                <div class="col-md-5">
                                    <select id="item" name="item" class="form-control">
                                        <option value="">===== 新闻类型 =====</option>
                                    </select>
                                </div>
                                <div class="col-md-4" id="itemSpan"></div>
                            </div>
                            <div class="form-group" id="contentDiv">
                                <label class="col-md-3 control-label" for="content">内容:</label>
                                <div class="col-md-5">
                                    <textarea type="text" id="content" name="content" class="form-control" placeholder="请输入新闻内容"></textarea>
                                </div>
                                <div class="col-md-4" id="contentSpan"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-5 col-md-offset-3">
                                    <button type="submit" class="btn btn-primary btn-sm" id="updateBtn">修改新闻信息</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success btn-sm" data-dismiss="modal">关闭编辑界面</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
