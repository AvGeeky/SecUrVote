package com.securvote.admin;

import com.securvote.database.db3;

import java.util.Scanner;

public class Admin {
    public static void main(String[] args) throws Exception {
        System.out.println(db3.viewElections());
        AdminControlBoard.main(args);
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Do you want to continue to resutls? ");
        String yn =scanner.nextLine();
        if (yn.equalsIgnoreCase("yes"))
            Verification.main(args);
    }
}

