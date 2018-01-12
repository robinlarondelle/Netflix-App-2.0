package com.nfs.userinterface;

import com.nfs.appdetails.AppDetails;
import com.nfs.appdetails.TimeKeeper;
import com.nfs.data.Movie;
import com.nfs.data.Show;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class InterfaceCreator {
    //Declarations

    //Information
    private JPanel informationPanel =  new JPanel(new BorderLayout());

    //Users
    private String[] userArray = new String[] {"Sander", "Robin", "Jac"};
    private JComboBox<String> profileDropdown = new JComboBox<>(userArray);
    private JLabel greeting = new JLabel(new TimeKeeper().greeting() + " " + getSelectedIem(), JLabel.CENTER);

    //Buttons
    private JButton statistieken;
    private JButton accountGegevens;
    private JButton profielGegevens;
    private JButton films;
    private JButton series;


    //Methods

    public JPanel createStartupInformation()    {

        JLabel information = new JLabel(new TimeKeeper().greeting(), JLabel.CENTER);

        //Label Make-up
        information.setFont(new Font("Arial", Font.BOLD, 36));
        information.setBorder(BorderFactory.createLineBorder(Color.gray));

        informationPanel.add(information, BorderLayout.CENTER);

        //Return Label
        return informationPanel;
    }

    public JPanel createProfileDropdown()    {

        //Creating the pane to add the dropdown and greeting
        JPanel profileContainer = new JPanel(new BorderLayout());

        //Setting up the dropdown. UserArray is a placeholder
        this.profileDropdown.setSelectedIndex(0);

        //Adding the Listener to the dropdown
        this.profileDropdown.addItemListener(new ItemListener());

        //Creating a sub-container for better alignment
        JPanel subContainer = new JPanel(new BorderLayout());
        subContainer.setBorder(new EmptyBorder(20, 20, 20, 20));

        //Adding the components to the containers
        subContainer.add(this.greeting);
        profileContainer.add(profileDropdown, BorderLayout.NORTH);
        profileContainer.add(subContainer, BorderLayout.SOUTH);

        return profileContainer;
    }

    private String getSelectedIem() {
        return userArray[profileDropdown.getSelectedIndex()];
    }

    public JPanel createButtons()  {

        //Setting up the panel
        JPanel buttons = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;

        //Setting up the buttons
        statistieken = new JButton("Statistieken");
        statistieken.addActionListener(new StatistiekenListener());
        statistieken.setMargin(new Insets(5, 0, 5, 0));

        accountGegevens = new JButton("Accountgegevens");
        accountGegevens.addActionListener(new AccountListener());
        accountGegevens.setMargin(new Insets(5, 0, 5, 0));

        profielGegevens = new JButton("Profile Gegevens");
        profielGegevens.addActionListener(new ProfielButtonListener());
        profielGegevens.setMargin(new Insets(5, 0, 5, 0));

        films = new JButton("Films");
        films.addActionListener(new FilmButtonListener());
        films.setMargin(new Insets(5, 0, 5, 0));

        series = new JButton("Series");
        series.addActionListener(new SerieButtonListener());
        series.setMargin(new Insets(5, 0, 5, 0));

        //Adding the buttons to the panel
        buttons.add(statistieken, c);
        buttons.add(accountGegevens, c);
        buttons.add(profielGegevens, c);
        buttons.add(films, c);
        buttons.add(series, c);

        return buttons;
    }

    public JPanel createCredits()   {

        //Create panel for labels
        JPanel creditsPanel = new JPanel(new BorderLayout());
        creditsPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        //Create Labels with information
        JLabel creditsAppVersion = new JLabel("Netflix Statistix versie " + new AppDetails().getVersion(), JLabel.LEFT);
        JLabel credits = new JLabel("Informatica 2017 - Klas E - " + new AppDetails().getAuthors(), JLabel.RIGHT);

        //Add labels to the container
        creditsPanel.add(creditsAppVersion, BorderLayout.WEST);
        creditsPanel.add(credits, BorderLayout.EAST);

        return creditsPanel;
    }

    public JPanel createProfielGegevens()  {
        JLabel hello = new JLabel("profielgegevens", JLabel.CENTER);
        JPanel helloPanel = new JPanel(new BorderLayout());
        helloPanel.add(hello, BorderLayout.NORTH);
        return helloPanel;
    }

    public JPanel createShowButtons()  {

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel west = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 70, 10);

        //width and height of the buttons, Non-scalable
        c.ipady = 100;
        c.ipadx = 55;


        //positioning
        c.gridy = 0;
        c.gridx = 0;
        buttonPanel.add(new JButton("Show 1"), c);

        c.gridx = 1;
        buttonPanel.add(new JButton("Show 2"), c);

        c.gridx = 2;
        buttonPanel.add(new JButton("Show 3"), c);

        c.gridx = 0;
        c.gridy = 1;
        buttonPanel.add(new JButton("Show 4"), c);

        c.gridx = 1;
        buttonPanel.add(new JButton("Show 5"), c);

        c.gridx = 2;
        buttonPanel.add(new JButton("Show 6"), c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        buttonPanel.add(new JButton("Show 7"), c);

        c.gridx = 1;
        buttonPanel.add(new JButton("Show 8"), c);

        c.gridx = 2;
        buttonPanel.add(new JButton("Show 9"), c);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        west.add(mainPanel, BorderLayout.WEST);

        return west;
    }

    public JPanel createFilmButtons()  {

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel west = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 70, 10);
        c.anchor = GridBagConstraints.NORTHWEST;

        //width and height of the buttons, Non-scalable
        c.ipady = 100;
        c.ipadx = 65;


        //positioning
        c.gridy = 0;
        c.gridx = 0;
        buttonPanel.add(new JButton("Movie 1"), c);

        c.gridx = 1;
        buttonPanel.add(new JButton("Movie 2"), c);

        c.gridx = 2;
        buttonPanel.add(new JButton("Movie 3"), c);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        west.add(mainPanel, BorderLayout.WEST);

        return west;
    }

    public JPanel createInformationAboutShow(String showName)   {

        JPanel main = new JPanel(new BorderLayout());
        Show show = new Show();
        JPanel jPanel = show.getInformationAboutShow(showName);

        return jPanel;
    }

    public JPanel createInformationAboutFilm(String filmName)   {
        Movie movie = new Movie();
        movie.getInformationAboutFilm(filmName);
        return null;
    }

    public JPanel createFilmPanel(String title, String genre, String Language, int age, int duration)    {

        //Assigning the parameters
        JLabel givenTitle = new JLabel(title);
        JLabel givenGenre = new JLabel(genre);
        JLabel givenLanguage = new JLabel(Language);
        JLabel givenAge = new JLabel(""+age+"+");
        JLabel givenDuration = new JLabel(""+duration+" min");

        //Setting up the new panel
        JPanel newPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        newPanel.add(givenTitle, gbc);

        gbc.gridheight = 2;



        return newPanel;
    }



    //SUBCLASSES



    class SerieButtonListener implements  ActionListener    {

        @Override
        public void actionPerformed(ActionEvent e) {
            pressButton(series);
            replacePane(createShowButtons());
        }
    }

    class FilmButtonListener implements ActionListener  {

        @Override
        public void actionPerformed(ActionEvent e) {
            pressButton(films);
            replacePane(createFilmButtons());
        }
    }

    class ProfielButtonListener implements ActionListener   {
        @Override
        public void actionPerformed(ActionEvent e) {
            pressButton(profielGegevens);
            replacePane(createProfielGegevens());
        }
    }

    class ItemListener implements java.awt.event.ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            //Changes text of label greeting when profile is changed
            greeting.setText(new TimeKeeper().greeting() + " " + getSelectedIem());

        }
    }

    class FilmSelectorButtonListener implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            createInformationAboutFilm("Sherlock");
        }
    }

    class ShowButtonListener implements ActionListener  {

        @Override
        public void actionPerformed(ActionEvent e) {
            createInformationAboutShow("Breaking Bad");
        }
    }


    class StatistiekenListener implements ActionListener    {

        @Override
        public void actionPerformed(ActionEvent e) {
            pressButton(statistieken);
            replacePane(new JLabel("Statistieken"));
        }
    }

    class AccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pressButton(accountGegevens);
            replacePane(new JLabel("Acountgegevens"));
        }
    }

    private void setAllButtonsEnabled()  {
        statistieken.setEnabled(true);
        accountGegevens.setEnabled(true);
        profielGegevens.setEnabled(true);
        films.setEnabled(true);
        series.setEnabled(true);
    }

    private void pressButton(JButton button)    {
        setAllButtonsEnabled();
        button.setEnabled(false);
    }

    private void replacePane(Component component)   {
        informationPanel.removeAll();
        informationPanel.add(component, BorderLayout.CENTER);
        informationPanel.updateUI();
    }

}
