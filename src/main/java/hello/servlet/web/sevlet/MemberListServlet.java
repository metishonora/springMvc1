package hello.servlet.web.sevlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();

        writer.write("""
                <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Members</title>
                </head>
                <body>
                <a href="/index.html">Main</a>
                <table>
                    <thead>
                    <th>id</th>
                    <th>username</th>
                    <th>age</th>
                    </thead>
                    <tbody>""");
        for (Member member : members) {
            writer.write("""
                    <tr>
                        <td>%d</td>
                        <td>%s</td>
                        <td>%d</td>
                    </tr>
                """.formatted(member.getId(), member.getUsername(), member.getAge()));
        }
        writer.write("""
                    </tbody>
                </table>
                </body>
                </html>
                """);
    }
}
