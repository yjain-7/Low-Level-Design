package com.crio.codingame.commands;

import java.util.List;
import java.util.Optional;
import com.crio.codingame.dtos.UserRegistrationDto;
import com.crio.codingame.entities.Contest;
import com.crio.codingame.exceptions.ContestNotFoundException;
import com.crio.codingame.repositories.ContestRepository;
import com.crio.codingame.services.IUserService;

public class WithdrawContestCommand implements ICommand{

    private final IUserService userService;
    private  ContestRepository contestRepository;
    public WithdrawContestCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute withdrawContest method of IUserService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["WITHDRAW_CONTEST","3","Joey"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        // Optional<Contest> contest = contestRepository.findById(tokens.get(1)).orElseThrow(() -> new ContestNotFoundException("Cannot Withdraw Contest. Contest for given id:"+tokens.get(1)+" not found!"));
        try {
            UserRegistrationDto user = userService.withdrawContest(tokens.get(1), tokens.get(2));
        System.out.println("RegisterContestDto [contestName="+user.getContestName()+", registerationStatus="+user.getRegisterationStatus()+", userName="+user.getUserName()+"]");
        } catch (RuntimeException e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    
}
