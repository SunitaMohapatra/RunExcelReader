package com.innovative.runexcelreader;
import com.innovative.excelfilereader.ApachePOIExcelReader;


public class RunExcelReader {
    public static void runExcelReader(String[] args){


        Cli cli = new Cli(args);
        cli.useExcelReaderParser();
        String FILE_NAME;
        int SHEET_INDEX;
        try{

            switch(args.length) {
                case 1:
                    System.out.println("No Arguments given.");
                    cli.PrintHelP();
                    break;
                case 2:
                {
                    //HelperMethods.printUsage();
                    FILE_NAME = args[1];
                    ApachePOIExcelReader.printMetadata(FILE_NAME);
                    break;
                }
                case 3:
                {
                    FILE_NAME = args[1];
                    SHEET_INDEX = Integer.parseInt(args[2]);
                    ApachePOIExcelReader.readWorksheet(FILE_NAME,SHEET_INDEX );
                    break;
                }
                case 6:{
                    FILE_NAME = args[1];
                    SHEET_INDEX = Integer.parseInt(args[2]);
                    int colNum = Integer.parseInt(args[3]);
                    char operator = args[4].charAt(0);
                    String operand = args[5];
                    ApachePOIExcelReader.printQuery(FILE_NAME,SHEET_INDEX,colNum,operator,operand);
                    break;
                }

                default:{
                    System.out.println("Wrong method usage.");
                    cli.PrintHelP();
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Something went wrong.");
            e.printStackTrace();
            // HelperMethods.printUsage();
        }
    }
}
