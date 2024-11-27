import * as vscode from 'vscode';

export async function activate(context: vscode.ExtensionContext) {
  const extName = 'GracefulPotato.ruby-better-highlighting';
  const extension = vscode.extensions.getExtension(extName);
  const currentTheme: string | undefined = vscode.workspace.getConfiguration('workbench').get('colorTheme');

  if (currentTheme?.includes('Gruvbox ish') && !extension && vscode.workspace.getConfiguration('gruvbox-ish').get('recommendRubyGrammar', true)) {
    const message = "For better syntax highlighting with this theme, it is recommended to install the 'Ruby Better Highlighting' extension. Do you want to install it now?";
    const choice = await vscode.window.showInformationMessage(message, 'Install', 'Not now', 'Do not show again');

    if (choice === 'Install') {
      await vscode.commands.executeCommand('extension.open', extName);
      await vscode.commands.executeCommand('workbench.extensions.installExtension', extName);
    } else if (choice === 'Do not show again') {
      vscode.workspace.getConfiguration('gruvbox-ish').update('recommendRubyGrammar', false, true);
    }
  }
}
