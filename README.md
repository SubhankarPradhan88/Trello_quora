# Trello Quora

This project consists of REST API endpoints of various functionalities required for a website (similar to Quora) from scratch.

List of end points:

UserController:
1. signup - "/user/signup"
2. signin - "/user/signin"
3. signout - "/user/signout"

CommonController:
1. userProfile - "/userprofile/{userId}"

AdminController:
1. userDelete - "/admin/user/{userId}"

QuestionController:
1. createQuestion - "/question/create"
2. getAllQuestions - "/question/all"
3. editQuestionContent - "/question/edit/{questionId}"
4. deleteQuestion - "/question/delete/{questionId}"
5. getAllQuestionsByUser - "question/all/{userId}"

AnswerController:
1. createAnswer - "/question/{questionId}/answer/create"
2. editAnswerContent - "/answer/edit/{answerId}"
3. deleteAnswer - "/answer/delete/{answerId}"
4. getAllAnswersToQuestion - "answer/all/{questionId}"
