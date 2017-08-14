package com.innovative.runexcelreader;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Cli {
    //private data members
    private static final Logger log = Logger.getLogger(Cli.class.getName());
    private String[] commandLineArguments = null;
    //creating option object
    private Options excelReaderOptions = new Options();

    public Cli(String[] args) {
        this.commandLineArguments = args;

        //add option: three parameters :The first parameter is a java.lang.String that represents the option.
        // The second parameter is a boolean that specifies whether the option requires an argument or not.
        //The third parameter is the description of the option

        excelReaderOptions.addOption("f","filePath",false,"filepath")
                .addOption("fw","<filepath>,<wn>", false, "filepath & worksheetNumber")
                .addOption("fwq","<filepath>,<wn>,<C>,<opr>,<opd>", true, "filename,worksheetnumber,column,operator & oprand")
                .addOption("h","help", false, "Show Usage");
    }
    //Parsing the command line argument

    public void useExcelReaderParser()
    {
        CommandLineParser parser = new BasicParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(excelReaderOptions, commandLineArguments);
            if (cmd.hasOption("h")) {
                PrintHelP();
            }
            if (cmd.hasOption("f")) {
                System.out.println("\n=============================================");
                log.log(Level.INFO, "Selected file path -f=" + cmd.getOptionValue("f"));
            }

            if (cmd.hasOption("fw")) {
                System.out.println("\n=============================================");
                log.log(Level.INFO, "Selected file path & worksheet -f=" + cmd.getOptionValue("fw"));
            }

            if (cmd.hasOption("fwq")) {
                System.out.println("\n=============================================");
                log.log(Level.INFO, "Selected file path -f=" + cmd.getOptionValue("fwq"));
            }
        }
        catch (ParseException parseException)
        {
            System.out.println("Invalid Command.Please check the usage");
            PrintHelP();
        }
        }
    // Generate help information with Apache Commons CLI.
    public void PrintHelP() {
        System.out.println("\n============================================");

        HelpFormatter formatter = new HelpFormatter();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        formatter.printHelp(" ", excelReaderOptions);
        System.out.println("\n=============================================");
        System.exit(0);
    }
}