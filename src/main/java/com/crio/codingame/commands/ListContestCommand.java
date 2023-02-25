package com.crio.codingame.commands;

import java.util.ArrayList;
import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.repositories.ContestRepository;
import com.crio.codingame.services.IContestService;

public class ListContestCommand implements ICommand{

    private final IContestService contestService;
    private ContestRepository contestRepository;
    public ListContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllContestLevelWise method of IContestService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LIST_CONTEST","HIGH"]
    // or
    // ["LIST_CONTEST"]

    @Override
    public void execute(List<String> tokens) {
        List<Contest> contest = new ArrayList<>();
        if(tokens.size() == 2){
            Level level = Level.valueOf(tokens.get(1));
            contest = contestService.getAllContestLevelWise(level);
        }else{
            contest = contestService.getAllContestLevelWise(null);
        }
        System.out.println(contest);
    }

    // <[Contest [id=1, name=contestName1, level=HIGH, creator=creator1, contestStatus=NOT_STARTED, questions=[Question [id=1, level=HIGH, score=100, title=title1], Question [id=2, level=HIGH, score=90, title=title2], Question [id=3, level=HIGH, score=80, title=title3]]], Contest [id=1, name=contestName2, level=HIGH, creator=creator2, contestStatus=NOT_STARTED, questions=[Question [id=4, level=HIGH, score=1100, title=title4], Question [id=5, level=HIGH, score=900, title=title5], Question [id=6, level=HIGH, score=800, title=title6]]]]>
    // <[Contest [id=1, name=contestName1, level=HIGH, creator=creator1, contestStatus=NOT_STARTED, questions=[]], Contest [id=1, name=contestName2, level=HIGH, creator=creator2, contestStatus=NOT_STARTED, questions=[]]]>
}
