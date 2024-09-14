package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    public CLIArguments() {

    }

    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            validateWith = CLIKeywordValidator.class,
            description = "KEYWORD"
    )
    private String keyword;

    @Parameter(
            names = {"--location", "-l"},
            description = "Each search may include a location"
    )
    private String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "The API return 50 results, use one number for the page"
    )
    private int page = 0;

    @Parameter(
            names = {"--full-time"},
            description = "Add if you want full time jobs"
    )
    private boolean isFullTime = false;

    @Parameter(
            names = {"--markdown"},
            description = "Get the results in markdown"
    )
    private boolean isMarkdown = false;

    @Parameter(
            names = "--help",
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Show this help"
    )
    private boolean isHelp;



    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isHelp() {
        return isHelp;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "isFullTime=" + isFullTime +
                ", keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }
}
