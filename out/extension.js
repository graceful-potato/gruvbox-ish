"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.activate = activate;
const vscode = require("vscode");
function activate(context) {
    return __awaiter(this, void 0, void 0, function* () {
        const extName = 'GracefulPotato.ruby-better-highlighting';
        const extension = vscode.extensions.getExtension(extName);
        const currentTheme = vscode.workspace.getConfiguration('workbench').get('colorTheme');
        if ((currentTheme === null || currentTheme === void 0 ? void 0 : currentTheme.includes('Gruvbox ish')) && !extension && vscode.workspace.getConfiguration('gruvbox-ish').get('recommendRubyGrammar', true)) {
            const message = "For better syntax highlighting with this theme, it is recommended to install the 'Ruby Better Highlighting' extension. Do you want to install it now?";
            const choice = yield vscode.window.showInformationMessage(message, 'Install', 'Not now', 'Do not show again');
            if (choice === 'Install') {
                yield vscode.commands.executeCommand('extension.open', extName);
                yield vscode.commands.executeCommand('workbench.extensions.installExtension', extName);
            }
            else if (choice === 'Do not show again') {
                vscode.workspace.getConfiguration('gruvbox-ish').update('recommendRubyGrammar', false, true);
            }
        }
    });
}
//# sourceMappingURL=extension.js.map