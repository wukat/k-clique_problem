/*
 * authors: Wojciech Kasperek & Krzysztof Spytkowski & Izabela Śmietana
 */
package GUI;

import Controller.GraphVisualizationAndButtonsStateActualizer;
import Controller.ApplicationController;
import Controller.PlotActualizer;
import exceptions.NoPossibilityToCreateGraphException;
import exceptions.ProblemWithReadingGraphFromFileException;
import genetics.CrossingOverType;
import genetics.IndividualType;
import genetics.SelectionType;
import graph.GraphRepresentation;
import graph.LayoutType;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import org.jfree.chart.ChartPanel;

public class KCliqueSolverGUI extends JFrame {

    private final ApplicationController controller; // controller
    private final GraphVisualizationAndButtonsStateActualizer graphActualizer; // thread that actualizes graph view
    private final PlotActualizer chartActualizer; // thread that actualizes chart
    private final ResultsViewPanel resultsPanel;

    /**
     * Creates new form KKliqueSolverGUI.
     */
    public KCliqueSolverGUI() {
        this.controller = new ApplicationController();
        initComponents();
        initChart();
        this.resultsPanel = new ResultsViewPanel(graphPanel, controller);
        tabChoosePanel.addTab("Simulation", simulationPanel);
        tabChoosePanel.addTab("Graph generation", new GraphGenerationPanel(graphPanel, controller, tabChoosePanel));
        tabChoosePanel.addTab("Simulation results through iterations", resultsPanel);
        graphActualizer = new GraphVisualizationAndButtonsStateActualizer(controller, graphPanel, stopButton, startButton, tabChoosePanel);
        chartActualizer = new PlotActualizer(chartPanelInGUI);
        controller.setActualizers(graphActualizer, chartActualizer);
        startThreads();
    }

    /**
     * Starts actualizers and main program.
     */
    private void startThreads() {
        graphActualizer.start();
        chartActualizer.start();
        controller.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        individualsEncodingCheckBoxGroup = new javax.swing.ButtonGroup();
        simulationPanel = new javax.swing.JPanel();
        crossingOverPanel = new javax.swing.JPanel();
        crossingOverProbabilityLabel = new javax.swing.JLabel();
        crossingOverTypeLabel = new javax.swing.JLabel();
        crossingOverTypeComboBox = new javax.swing.JComboBox();
        crossingOverProbabilitySpinner = new javax.swing.JSpinner(new SpinnerNumberModel(0.6, 0.00, 1.0, 0.01));
        mutationPanel = new javax.swing.JPanel();
        mutationProbabilityLabel = new javax.swing.JLabel();
        mutationProbabilitySpinner = new javax.swing.JSpinner(new SpinnerNumberModel(0.05, 0.00, 1.0, 0.01));
        selectionPanel = new javax.swing.JPanel();
        selectionTypeComboBox = new javax.swing.JComboBox();
        selectionTypeLabel = new javax.swing.JLabel();
        populationPanel = new javax.swing.JPanel();
        amountOfIndividualsLabel = new javax.swing.JLabel();
        amountOfIndividualsSpinner = new javax.swing.JSpinner(new SpinnerNumberModel(20, 10, 100, 1));
        numberOfGenerationsLabel = new javax.swing.JLabel();
        numberOfGenerationsSpinner = new javax.swing.JSpinner(new SpinnerNumberModel(500, 100, 2000, 1));
        controlPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        searchedKCliqueSizeLabel = new javax.swing.JLabel();
        searchedKCliqueSizeSpinnerNumberModel = new SpinnerNumberModel(0,0,0,1);
        searchedKCliqueSizeSpinner = new javax.swing.JSpinner(searchedKCliqueSizeSpinnerNumberModel);
        individualsEncodingPanel = new javax.swing.JPanel();
        groupCodingCheckBox = new javax.swing.JCheckBox();
        numberOfGroupsLabel = new javax.swing.JLabel();
        numberOfGroupsSpinner = new javax.swing.JSpinner(new SpinnerNumberModel(4, 4, 16, 1));
        binaryCodingCheckBox = new javax.swing.JCheckBox();
        mainGraphPanel = new javax.swing.JPanel();
        tabChoosePanel = new javax.swing.JTabbedPane();
        chartPanelInGUI = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        individualsEncodingCheckBoxGroup.add(binaryCodingCheckBox);

        individualsEncodingCheckBoxGroup.add(groupCodingCheckBox);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("K-Clique Problem Solver");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        simulationPanel.setBorder(null);
        simulationPanel.setMaximumSize(new java.awt.Dimension(1000, 1022));
        simulationPanel.setPreferredSize(new java.awt.Dimension(642, 711));

        crossingOverPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Crossing-over"));

        crossingOverProbabilityLabel.setText("Probability");

        crossingOverTypeLabel.setText("Type");

        crossingOverTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "one point with two children", "one point with one child", "uniform", "weighted uniform", "two points with two children", "two points with one child" }));

        crossingOverProbabilitySpinner.setToolTipText("Set value form 0 to 1.");
        crossingOverProbabilitySpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout crossingOverPanelLayout = new javax.swing.GroupLayout(crossingOverPanel);
        crossingOverPanel.setLayout(crossingOverPanelLayout);
        crossingOverPanelLayout.setHorizontalGroup(
            crossingOverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crossingOverPanelLayout.createSequentialGroup()
                .addComponent(crossingOverProbabilityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crossingOverProbabilitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(crossingOverTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crossingOverTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        crossingOverPanelLayout.setVerticalGroup(
            crossingOverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crossingOverPanelLayout.createSequentialGroup()
                .addGroup(crossingOverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crossingOverProbabilityLabel)
                    .addComponent(crossingOverProbabilitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crossingOverTypeLabel)
                    .addComponent(crossingOverTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mutationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Mutation"));

        mutationProbabilityLabel.setText("Probability");

        mutationProbabilitySpinner.setToolTipText("Set value from 0 to 1.");

        javax.swing.GroupLayout mutationPanelLayout = new javax.swing.GroupLayout(mutationPanel);
        mutationPanel.setLayout(mutationPanelLayout);
        mutationPanelLayout.setHorizontalGroup(
            mutationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mutationPanelLayout.createSequentialGroup()
                .addComponent(mutationProbabilityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mutationProbabilitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mutationPanelLayout.setVerticalGroup(
            mutationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mutationPanelLayout.createSequentialGroup()
                .addGroup(mutationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mutationProbabilityLabel)
                    .addComponent(mutationProbabilitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        selectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Selection"));

        selectionTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "tournament", "roulette", "linear ranking" }));

        selectionTypeLabel.setText("Type");

        javax.swing.GroupLayout selectionPanelLayout = new javax.swing.GroupLayout(selectionPanel);
        selectionPanel.setLayout(selectionPanelLayout);
        selectionPanelLayout.setHorizontalGroup(
            selectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectionTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectionTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        selectionPanelLayout.setVerticalGroup(
            selectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(selectionTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(selectionTypeLabel))
        );

        populationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Population"));

        amountOfIndividualsLabel.setText("Amount of individuals");

        amountOfIndividualsSpinner.setToolTipText("Set value from 10 to 100.");

        numberOfGenerationsLabel.setText("Number of generations");

        numberOfGenerationsSpinner.setToolTipText("Set value from 100 to 2000.");

        javax.swing.GroupLayout populationPanelLayout = new javax.swing.GroupLayout(populationPanel);
        populationPanel.setLayout(populationPanelLayout);
        populationPanelLayout.setHorizontalGroup(
            populationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(populationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(amountOfIndividualsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amountOfIndividualsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numberOfGenerationsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberOfGenerationsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        populationPanelLayout.setVerticalGroup(
            populationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(populationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(amountOfIndividualsLabel)
                .addComponent(amountOfIndividualsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(numberOfGenerationsLabel)
                .addComponent(numberOfGenerationsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        controlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));

        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setText("STOP");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        searchedKCliqueSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchedKCliqueSizeLabel.setText("Searched K-Clique size");
        searchedKCliqueSizeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        searchedKCliqueSizeSpinner.setToolTipText("Set value from 2 to number of vertices in graph. 0 set if there's no graph.");

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchedKCliqueSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchedKCliqueSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(startButton)
                .addComponent(stopButton)
                .addComponent(searchedKCliqueSizeLabel)
                .addComponent(searchedKCliqueSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        individualsEncodingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Individual's encoding"));

        groupCodingCheckBox.setText("group");
        groupCodingCheckBox.setSelected(false);
        groupCodingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupCodingCheckBoxActionPerformed(evt);
            }
        });

        numberOfGroupsLabel.setText("Number of groups");

        numberOfGroupsSpinner.setToolTipText("Set value from 4 to 16 or to number of vertices, if it's smaller than 16.");
        numberOfGroupsSpinner.setEnabled(false);

        binaryCodingCheckBox.setText("binary");
        binaryCodingCheckBox.setSelected(true);
        binaryCodingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binaryCodingCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout individualsEncodingPanelLayout = new javax.swing.GroupLayout(individualsEncodingPanel);
        individualsEncodingPanel.setLayout(individualsEncodingPanelLayout);
        individualsEncodingPanelLayout.setHorizontalGroup(
            individualsEncodingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(individualsEncodingPanelLayout.createSequentialGroup()
                .addComponent(binaryCodingCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(groupCodingCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numberOfGroupsLabel)
                .addGap(18, 18, 18)
                .addComponent(numberOfGroupsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        individualsEncodingPanelLayout.setVerticalGroup(
            individualsEncodingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(individualsEncodingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(groupCodingCheckBox)
                .addComponent(numberOfGroupsLabel)
                .addComponent(numberOfGroupsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(binaryCodingCheckBox))
        );

        javax.swing.GroupLayout simulationPanelLayout = new javax.swing.GroupLayout(simulationPanel);
        simulationPanel.setLayout(simulationPanelLayout);
        simulationPanelLayout.setHorizontalGroup(
            simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simulationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(simulationPanelLayout.createSequentialGroup()
                        .addComponent(individualsEncodingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(populationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(simulationPanelLayout.createSequentialGroup()
                        .addComponent(crossingOverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mutationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        simulationPanelLayout.setVerticalGroup(
            simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simulationPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(populationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(individualsEncodingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crossingOverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mutationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainGraphPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 254, 254)));
        mainGraphPanel.setMaximumSize(new java.awt.Dimension(400, 1400));
        mainGraphPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        mainGraphPanel.setLayout(new java.awt.BorderLayout());

        tabChoosePanel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabChoosePanelStateChanged(evt);
            }
        });

        chartPanelInGUI.setBackground(new java.awt.Color(254, 254, 254));
        chartPanelInGUI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 254, 254)));

        javax.swing.GroupLayout chartPanelInGUILayout = new javax.swing.GroupLayout(chartPanelInGUI);
        chartPanelInGUI.setLayout(chartPanelInGUILayout);
        chartPanelInGUILayout.setHorizontalGroup(
            chartPanelInGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chartPanelInGUILayout.setVerticalGroup(
            chartPanelInGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        menuBar.setToolTipText("K-Klique Problem Solver");

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainGraphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabChoosePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addComponent(simulationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(chartPanelInGUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabChoosePanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simulationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartPanelInGUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainGraphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        graphPanel = new GraphPanel();
        mainGraphPanel.add(graphPanel);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void binaryCodingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binaryCodingCheckBoxActionPerformed
        numberOfGroupsSpinner.setEnabled(false);
    }//GEN-LAST:event_binaryCodingCheckBoxActionPerformed

    private void groupCodingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupCodingCheckBoxActionPerformed
        if (actualizeNumberOfGroupsSpinner()) {
            JOptionPane.showMessageDialog(simulationPanel, "There's no sense to use group "
                    + "coding on so small graph! Use binary encoding instead.",
                    "Clue", JOptionPane.INFORMATION_MESSAGE);
        } else {
            numberOfGroupsSpinner.setEnabled(true);
        }
    }//GEN-LAST:event_groupCodingCheckBoxActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        actualizeController();
        while (!controller.isFinished()) {
            controller.stopSolving();
        }
        synchronized (controller) {
            if (controller.getGraphRepresentation() != null) {
                tabChoosePanel.setEnabledAt((tabChoosePanel.getSelectedIndex() + 1) % 3, false);
                tabChoosePanel.setEnabledAt((tabChoosePanel.getSelectedIndex() + 2) % 3, false);
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                controller.getPlot().clearAllSeries();
                controller.resumeSolving();
                controller.getGraphRepresentation().setsearchedKCliqueSize((int) searchedKCliqueSizeSpinner.getValue());
            } else {
                JOptionPane.showMessageDialog(simulationPanel, "There's no graph!\nSwitch to graph genearation panel!",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        stopButton.setEnabled(false);
        controller.stopSolving();
        tabChoosePanel.setEnabledAt((tabChoosePanel.getSelectedIndex() + 1) % 3, true);
        tabChoosePanel.setEnabledAt((tabChoosePanel.getSelectedIndex() + 2) % 3, true);
        startButton.setEnabled(true);
    }//GEN-LAST:event_stopButtonActionPerformed

    private void tabChoosePanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabChoosePanelStateChanged
        if (tabChoosePanel.getSelectedIndex() == 0 && controller.getGraphRepresentation() != null) {
            actualizeSearchedKCliqueSizeSpinner();
            actualizeNumberOfGroupsSpinner();
        } else if (tabChoosePanel.getSelectedIndex() == 2) {
            resultsPanel.actualizeIterationSpinnerAndLabel();
        }
    }//GEN-LAST:event_tabChoosePanelStateChanged

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /**
     * Adds and shows empty chart in GUI.
     */
    private void initChart() {
        ChartPanel myChartPanel = controller.getPlot().getChartPanel();
        myChartPanel.setSize(chartPanelInGUI.getWidth(), chartPanelInGUI.getHeight());
        chartPanelInGUI.add(myChartPanel);
    }

    /**
     * Actualizes controller with data collected from GUI.
     */
    private void actualizeController() {
        controller.setNumberOfIndividuals((int) amountOfIndividualsSpinner.getValue());
        controller.setCrossingOverProbability((double) crossingOverProbabilitySpinner.getValue());
        controller.setHowToCross(CrossingOverType.getAtIndex(crossingOverTypeComboBox.getSelectedIndex()));
        controller.setHowToSelect(SelectionType.getAtIndex(selectionTypeComboBox.getSelectedIndex()));
        controller.setIndividualEncoding((groupCodingCheckBox.isSelected()) ? IndividualType.GROUPCODEDINDIVIDUAL : IndividualType.BINARYCODEDINDIVIDUAL);
        if (groupCodingCheckBox.isSelected()) {
            controller.setNumberOfGroupsInGroupEncoding((int) numberOfGroupsSpinner.getValue());
        }
        controller.setMutationProbability((double) mutationProbabilitySpinner.getValue());
        controller.setNumberOfIterations((int) numberOfGenerationsSpinner.getValue());
    }

    private void loadGraphMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser databaseFileChooser = new JFileChooser();
        int option = databaseFileChooser.showDialog(this, "Import");
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                controller.setGraphRepresentation(new GraphRepresentation(databaseFileChooser.getSelectedFile().getAbsolutePath()));
                actualizeSearchedKCliqueSizeSpinner();
                graphPanel.setLayoutType(LayoutType.CIRCLE);
                graphPanel.displayNewGraph(controller.getGraphRepresentation().getGraph());
            } catch (NoPossibilityToCreateGraphException | ProblemWithReadingGraphFromFileException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

    /**
     * Actualizes current and maximum value in spinner.
     */
    private void actualizeSearchedKCliqueSizeSpinner() {
        int oldValue = (int) searchedKCliqueSizeSpinnerNumberModel.getValue();
        if (oldValue != 0) {
            if (oldValue <= controller.getGraphRepresentation().getVertexCount()) {
                searchedKCliqueSizeSpinnerNumberModel = new SpinnerNumberModel(oldValue, 2, controller.getGraphRepresentation().getVertexCount(), 1);
            } else {
                searchedKCliqueSizeSpinnerNumberModel = new SpinnerNumberModel(controller.getGraphRepresentation().getVertexCount(), 2, controller.getGraphRepresentation().getVertexCount(), 1);
            }
        } else {
            searchedKCliqueSizeSpinnerNumberModel = new SpinnerNumberModel(2, 2, controller.getGraphRepresentation().getVertexCount(), 1);
        }
        searchedKCliqueSizeSpinner.setModel(searchedKCliqueSizeSpinnerNumberModel);
    }

    /**
     * Actualizes spinner's range (from 4 to number of vertexes in actual graph
     * or to 16).
     *
     * @return true if graph is too small to use group enciding
     */
    private boolean actualizeNumberOfGroupsSpinner() {
        boolean notEnoughtVertexes = true;
        int oldValue = (int) numberOfGroupsSpinner.getValue();
        SpinnerNumberModel model;
        if (controller.getGraphRepresentation() != null) {
            int vertexAmount = controller.getGraphRepresentation().getVertexCount();
            if (vertexAmount >= 4) {
                notEnoughtVertexes = false;
                if (vertexAmount < 16 && oldValue <= vertexAmount) {
                    model = new SpinnerNumberModel(oldValue, 4, vertexAmount, 1);
                } else if (vertexAmount < 16) {
                    model = new SpinnerNumberModel(vertexAmount, 4, vertexAmount, 1);
                } else {
                    model = new SpinnerNumberModel(oldValue, 4, 16, 1);
                }
                numberOfGroupsSpinner.setModel(model);
            } else {
                groupCodingCheckBox.setSelected(false);
                binaryCodingCheckBox.setSelected(true);
                numberOfGroupsSpinner.setEnabled(false);
            }
        } else {
            return false;
        }
        return notEnoughtVertexes;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel. For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KCliqueSolverGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KCliqueSolverGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JLabel amountOfIndividualsLabel;
    private javax.swing.JSpinner amountOfIndividualsSpinner;
    private javax.swing.JCheckBox binaryCodingCheckBox;
    private javax.swing.JPanel chartPanelInGUI;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel crossingOverPanel;
    private javax.swing.JLabel crossingOverProbabilityLabel;
    private javax.swing.JSpinner crossingOverProbabilitySpinner;
    private javax.swing.JComboBox crossingOverTypeComboBox;
    private javax.swing.JLabel crossingOverTypeLabel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JCheckBox groupCodingCheckBox;
    private javax.swing.JMenu helpMenu;
    private javax.swing.ButtonGroup individualsEncodingCheckBoxGroup;
    private javax.swing.JPanel individualsEncodingPanel;
    private GraphPanel graphPanel;
    private javax.swing.JPanel mainGraphPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel mutationPanel;
    private javax.swing.JLabel mutationProbabilityLabel;
    private javax.swing.JSpinner mutationProbabilitySpinner;
    private javax.swing.JLabel numberOfGenerationsLabel;
    private javax.swing.JSpinner numberOfGenerationsSpinner;
    private javax.swing.JLabel numberOfGroupsLabel;
    private javax.swing.JSpinner numberOfGroupsSpinner;
    private javax.swing.JPanel populationPanel;
    private javax.swing.JLabel searchedKCliqueSizeLabel;
    private javax.swing.SpinnerModel searchedKCliqueSizeSpinnerNumberModel;
    private javax.swing.JSpinner searchedKCliqueSizeSpinner;
    private javax.swing.JPanel selectionPanel;
    private javax.swing.JComboBox selectionTypeComboBox;
    private javax.swing.JLabel selectionTypeLabel;
    private javax.swing.JPanel simulationPanel;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JTabbedPane tabChoosePanel;
    // End of variables declaration//GEN-END:variables
}
