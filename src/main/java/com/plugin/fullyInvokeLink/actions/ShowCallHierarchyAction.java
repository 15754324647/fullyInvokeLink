package com.plugin.fullyInvokeLink.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.util.ui.tree.TreeUtil;
import com.intellij.util.xml.ui.PsiClassPanel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * @author limeiqi5
 * @date 2024/01/26
 */
public class ShowCallHierarchyAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Project project = event.getProject();
        if (project != null) {
            // 在这里编写获取当前所选类的方法调用链路的逻辑
            PsiClassPanel selectedClass = YourLogicToGetSelectedClass();

            // 创建调用链路的树形结构并显示在一个新的窗口中
            JTree callTree = createCallHierarchyTree(selectedClass);
            showHierarchyWindow(callTree);
        }
    }

    /**
     * 编写自定义逻辑以获取当前选定的类
     */
    private PsiClassPanel YourLogicToGetSelectedClass() {
        // 在这里编写获取当前所选类的逻辑
        return new PsiClassPanel();
    }

    /**
     * 创建调用链路的树形结构
     */
    private JTree createCallHierarchyTree(PsiClassPanel selectedClass) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(selectedClass.getName());
        // 在这里编写遍历并添加调用链路节点的逻辑

        // 创建树形结构
        JTree callTree = new JTree(new DefaultTreeModel(root));
        TreeUtil.expandAll(callTree);
        return callTree;
    }

    /**
     * 在新窗口中展示调用链路树
     */
    private void showHierarchyWindow(JTree callTree) {
        JFrame frame = new JFrame("Call Hierarchy");
        JScrollPane scrollPane = new JScrollPane(callTree);
        frame.getContentPane().add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        // 居中显示窗口
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}