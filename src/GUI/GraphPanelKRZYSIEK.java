/*
 * authors: Wojciech Kasperek & Krzysztof Spytkowski
 */
package GUI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;

import javax.swing.JPanel;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import genetics.AbstractIndividual;
import graph.GraphVisualisation;
import graph.LayoutType;

/**
 * 
 * @author wukat
 */
public class GraphPanelKRZYSIEK extends JPanel {

    
    private VisualizationViewer<Integer, String> vv = null; // visualization viewer of graph
    private Layout<Integer, String> actualGrLayout = null; // displayed layout
    private Graph<Integer, String> graph; // graph
    private LayoutType layoutType = LayoutType.CIRCLE; // actually chosen layout of a graph
    AbstractIndividual best;

    
    public void setBest(AbstractIndividual best) {
        this.best = best;
    }
    /**
     * Constructor
     */
    public GraphPanelKRZYSIEK() {
        setBackground(Color.white);
    }

    /**
     * Sets new layout type
     * 
     * @param layoutType
     *            - type of layout
     */
    public void setLayoutType(LayoutType layoutType) {
        this.layoutType = layoutType;
    }

    public void repaint() {
        super.repaint();
        if (graph != null) {
            add(actualizeVisualization(best));
            validate();
            revalidate();
        }
    }

    /**
     * Function actualizes graph on the screen
     * 
     * @param g
     *            - new graph
     * @param layoutType
     *            - type of layout to visualization of graph
     */
    public final void displayNewGraph(Graph<Integer, String> g) {
        this.graph = g;
        
        add(actualizeVisualization(null));
        validate();
        revalidate();
    }

    /**
     * Creates visualization of a graph with best one from population
     * 
     * @param bestOne
     *            - best subgraph from population
     * @return visualization
     */
    public VisualizationViewer<Integer, String> actualizeVisualization(AbstractIndividual bestOne) { // Individual => AbstractIndividual
        removeAll();
        setBest(bestOne);
        actualGrLayout = GraphVisualisation.getLayout(graph, layoutType);
        vv = new VisualizationViewer<>(actualGrLayout, getSize());
        vv.setBackground(Color.WHITE);
       // vv.setGraphMouse(new DefaultModalGraphMouse<String, Number>());

        vv.getRenderContext().setVertexDrawPaintTransformer(new VertexDrawing());
        vv.getRenderContext().setVertexFillPaintTransformer(new VertexPainting(bestOne));
        vv.getRenderContext().setEdgeDrawPaintTransformer(new EdgePainting(bestOne));
        vv.getRenderContext().setEdgeStrokeTransformer(new EdgeThickness(bestOne));
        return vv;
    }

    /**
     * Paints edges - if it's in a best one, it's blue; otherwise black
     */
    public class EdgePainting implements Transformer<String, Paint> {

        // byte[] arr; // array with notes of vertices
        AbstractIndividual a;

        public void setIndividual(AbstractIndividual a) {
            this.a = a;
        }

        /**
         * Constructor
         * 
         * @param arr
         *            - array with notes of vertices
         */
        public EdgePainting(AbstractIndividual arr) {
            this.a = arr;
        }

        @Override
        public Paint transform(String e) {
            if (a != null) {
                boolean flag = false;
                for (int i : graph.getEndpoints(e)) {
                    if (a.getChromosome()[i - 1] == 0) {
                        flag = true;
                    }
                }
                if (!flag) {
                    return Color.BLUE;
                }
            }
            return Color.BLACK;
        }
    }

    /**
     * Sets edge thickness, thick - in best one
     */
    public class EdgeThickness implements Transformer<String, Stroke> {

        AbstractIndividual arr;
        // byte[] arr; // array with notes of vertices
        protected final Stroke THIN = new BasicStroke(1); // thickness
        protected final Stroke THICK = new BasicStroke(2);

        public void setIndividual(AbstractIndividual a) {
            this.arr = a;
        }

        /**
         * Constructor
         * 
         * @param arr
         *            - array with notes of vertices
         */
        public EdgeThickness(AbstractIndividual arr) {
            this.arr = arr;
        }

        @Override
        public Stroke transform(String e) {
            if (arr != null) {
                boolean flag = false;
                for (int i : graph.getEndpoints(e)) {
                    if (arr.getChromosome()[i - 1] == 0) {
                        flag = true;
                    }
                }
                if (!flag) {
                    return THICK;
                }
            }
            return THIN;
        }
    }

    /**
     * Draw black border of vertex
     */
    public class VertexDrawing implements Transformer<Integer, Paint> {

        @Override
        public Paint transform(Integer v) {
            return Color.BLACK;
        }

    }

    /**
     * Sets color of vertex; yellow - in best one; red - otherwise
     */
    public class VertexPainting implements Transformer<Integer, Paint> {

        // byte[] arr; // array with notes of vertices
        AbstractIndividual arr;

        public void setIndividual(AbstractIndividual a) {
            this.arr = a;
        }

        /**
         * Constructor
         * 
         * @param arr
         *            - array with notes of vertices
         */
        public VertexPainting(AbstractIndividual arr) {
            this.arr = arr;
        }

        @Override
        public Paint transform(Integer i) {
            if (arr != null) {
                if (1 == arr.getChromosome()[i - 1]) { // zamin na 0 i w bunary 0 beda tez najlepsze
                    return Color.YELLOW;
                }
            }
            return Color.RED;
        }

    }
}