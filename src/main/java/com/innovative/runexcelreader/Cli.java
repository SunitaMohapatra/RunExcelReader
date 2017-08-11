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

    private static final Logger log = Logger.getLogger(Cli.class.getName());
    private String[] commandLineArguments = null;
    private Options excelReaderOptions = new Options();

    public Cli(String[] args) {
        this.commandLineArguments = args;

        excelReaderOptions.addOption("f","filePath",false,"filepath")
                .addOption("fw","<filepath>,<wn>", false, "filepath & worksheetNumber")
                .addOption("fwq","<filepath>,<wn>,<C>,<opr>,<opd>", true, "filename,worksheetnumber,column,operator & oprand")
                .addOption("h","help", false, "Show Usage");
    }

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
            /*else {

                log.log(Level.SEVERE, "Missing filepath(Filepath is mandatory).Please look usage for information");
                PrintHelP();
            } */
            if (cmd.hasOption("fw")) {
                System.out.println("\n=============================================");
                log.log(Level.INFO, "Selected file path & worksheet -f=" + cmd.getOptionValue("fw"));
            }

            if (cmd.hasOption("fwq")) {
                System.out.println("\n=============================================");
                log.log(Level.INFO, "Selected file path -f=" + cmd.getOptionValue("fwq"));
            }

            /*if (cmd.hasOption("fw") && cmd.hasOption("f") && cmd.hasOption("fwq"))
            {
                log.log(Level.INFO, "Using cli argument -f=" + cmd.getOptionValue("f") + "-fw" + cmd.getOptionValue("fw") + "-fw" + cmd.getOptionValue("fwq"));
            }
            /*if (!cmd.hasOption("fw") && !cmd.hasOption("f") && cmd.hasOption("fwq"))
            {
                    log.log(Level.SEVERE, "Missing file worksheet option.Please look the help for more information");
                    PrintHelP();
                }

            if (cmd.hasOption("fw") && !cmd.hasOption("f") && cmd.hasOption("fwq"))
            {
                log.log(Level.SEVERE, "Missing filepath & file worksheet option.Please look the help for more information");
                PrintHelP();
            }
            if (!cmd.hasOption("fw") && cmd.hasOption("f") && cmd.hasOption("fwq"))
            {
                log.log(Level.SEVERE, "Missing filepath & file worksheet option.Please look the help for more information");
                PrintHelP();
            }
            //for query//"<filepath>,<w>,<C>,<opr>,<opd>" if column name ,operator,operand anyone is missing from the arguement then help page should get display

            if (cmd.hasOption("fw") && cmd.hasOption("f") && (cmd.hasOption("fwq") && !cmd.hasOption("<c>&&<opr>&&<opd>")))
            {
                log.log(Level.SEVERE, "Your query has missing arguments.Please check the usage for details");
                PrintHelP();
            }*/
        }
        catch (ParseException parseException)
        {
            //log.log(Level.SEVERE, "Failed to parse command line properties", parseException);
            System.out.println("Invalid Command.Please check the usage");

            PrintHelP();
        }
    }
    public void PrintHelP() {
        System.out.println("\n============================================");

        HelpFormatter formatter = new HelpFormatter();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        formatter.printHelp(" ", excelReaderOptions);
        System.out.println("\n=============================================");
        System.exit(0);
    }
}