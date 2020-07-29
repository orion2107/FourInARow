package View;

import Model.Board;

import java.util.ArrayList;
import java.util.List;

public class ProxyViewer implements ViewerInterface {

    List<ViewerInterface> viewers;

    public ProxyViewer() {
        this.viewers = new ArrayList<ViewerInterface>();
    }

    public void addViewer(ViewerInterface newViewer) {
        viewers.add(newViewer);
    }

    public void removeViewer(ViewerInterface viewer) {
        viewers.remove(viewer);
    }

    public void display(Board board) {

    }
}
