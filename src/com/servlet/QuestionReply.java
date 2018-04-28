package com.servlet;

import com.user.Question;
import com.user.Reply;
import com.user.User;
import com.userdao.QuestionReplyDao;
import com.userdao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "QuestionReply")
public class QuestionReply extends HttpServlet {
    QuestionReplyDao qro=new QuestionReplyDao();
    UserDao userdao=new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String methodname = request.getParameter("methodname");
        //add the question into the question list
        if(methodname.equals("addQuestion")){
            String questionInfo = request.getParameter("questionInfo");
            Question question=new Question();
            question.setQuestionInfo(questionInfo);
            User user=(User) session.getAttribute("user");
            question.setQuestionUser(user.getUserId());
            question.setQuestionUsername(user.getUserName());
            question.setQuestiontime(new Date().toString());
            qro.insertQuestion(question);
            //the peanuts number
            userdao.increaseUserPeanut(user, user.getUserPeanuts()-50);
            User suser=userdao.queryUserPeanut("stefan");
            userdao.increaseUserPeanut(suser, 20);
            List<Question> questionlist=qro.queryAllQuestion();
            request.setAttribute("questionlist", questionlist);
            request.getRequestDispatcher("problemSolving.jsp").forward(request, response);

        }else if(methodname.equals("addReply")){//follow the questionid
            String replyInfo = request.getParameter("replyInfo");
            String questionid = request.getParameter("questionid");
            Reply reply=new Reply();
            reply.setReplyInfo(replyInfo);
            User user=(User) session.getAttribute("user");
            reply.setReplyUser(user.getUserId());
            reply.setReplyQuestion(Integer.valueOf(questionid));
            reply.setReplyTime(new Date().toString());
            reply.setReplyusername(user.getUserName());
            qro.insertReply(reply);
            List<Reply> replylist=qro.queryReplyByQuestionId(questionid);
            Question question=qro.queryQuestionByQuestionId(questionid);
            request.setAttribute("question", question);
            request.setAttribute("replylist", replylist);
            request.getRequestDispatcher("problemReply.jsp").forward(request, response);
        }else if(methodname.equals("addBestReply")){//select the best bestreply and count the peanuts
            String questionid = request.getParameter("questionid");
            List<Reply> replylist=qro.queryReplyByQuestionId(questionid);
            Question question=qro.queryQuestionByQuestionId(questionid);
            request.setAttribute("question", question);
            request.setAttribute("replylist", replylist);
            String bestreply=request.getParameter("bestanswer");
            question.setQuestionBestReply(Integer.valueOf(bestreply));
            qro.updateBestReply(question.getQuestionId(), Integer.valueOf(bestreply));
            Reply reply=qro.queryReplyByReplyId(bestreply);
            User user=userdao.queryUserPeanut(reply.getReplyusername());
            //get the best replay and give the peanuts to the customer
            qro.updateUserPeanut(user.getUserId(), user.getUserPeanuts()+30);
            request.getRequestDispatcher("problemReply.jsp").forward(request, response);

        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String methodname = request.getParameter("methodname");
        if(methodname.equals("queryQuestion")){//
            List<Question> questionlist=qro.queryAllQuestion();
            request.setAttribute("questionlist", questionlist);
            request.getRequestDispatcher("problemSolving.jsp").forward(request, response);

        }else if(methodname.equals("queryReply")){
            String questionid = request.getParameter("questionid");
            Question question=qro.queryQuestionByQuestionId(questionid);
            List<Reply> replylist=qro.queryReplyByQuestionId(questionid);
            request.setAttribute("replylist", replylist);
            request.setAttribute("question", question);
            request.getRequestDispatcher("problemReply.jsp").forward(request, response);
        }

    }
}
