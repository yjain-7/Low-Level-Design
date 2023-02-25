package com.crio.codingame.commands;

import java.util.ArrayList;
import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;
import com.crio.codingame.services.IContestService;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

  

    @Override
    public void execute(List<String> tokens) {
        try {
            Level level = Level.valueOf(tokens.get(2));
            Contest contest;
            if(tokens.size() == 5){
                contest = contestService.create(tokens.get(1), level, tokens.get(3), Integer.parseInt(tokens.get(4)));
            }else{
                contest = contestService.create(tokens.get(1), level, tokens.get(3), null);
            }
            List<Question> questions = contest.getQuestions();
            System.out.println("Contest [id="+contest.getId()+", name="+contest.getName()+", level="+contest.getLevel()+", creator="+contest.getCreator().getName()+","
            +" contestStatus="+contest.getContestStatus()+", questions="+questions+"]");
        } catch (RuntimeException e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        
    }
}