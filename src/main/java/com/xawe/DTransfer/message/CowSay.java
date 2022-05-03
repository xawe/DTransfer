package com.xawe.dtransfer.message;

public class CowSay {

    public static String getMessage(AvatarEnum avatar, String message){            		
        StringBuilder sb = new StringBuilder();
		
        sb.append("  ");
        sb.append("\n");
		
		for (int i = 0; i <= message.length() + 1; i++) {		
            sb.append("_");
		}		
        sb.append("\n");        
				
		sb.append(" < " + message + " >\n");
		
		System.out.print("  ");
		for (int i = 0; i <= message.length() + 1; i++) {			
            sb.append("-");
		}		
        sb.append("\n");		
		
        sb.append(getAvatar(avatar));
        return sb.toString();
    }

    private static String getAvatar(AvatarEnum avatar){
        if(avatar.equals(AvatarEnum.TUX)){
            return getTux();
        }else if(avatar.equals(AvatarEnum.MIMOSA)){
            return getMimosa();
        }else if(avatar.equals(AvatarEnum.BEAVIS)){
            return getBeavis();
        }else if(avatar.equals(AvatarEnum.BEAR)){
            return getBear();
        }
        return getMimosa();     
    }

    public static String getTux(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");		
		
        sb.append("    \\\n");
		sb.append("     \\\n");
		sb.append("      \\\n");
		sb.append("         .--.\n");
		sb.append("        |o_o |\n");
		sb.append("        |:_/ |\n");
		sb.append("       //   \\ \\\n");
		sb.append("      (|     | )\n");
		sb.append("     /'\\_   _/`\\\n");
		sb.append("     \\___)=(___/\n");

        return sb.toString();
    }

    public static String getMimosa(){
        StringBuilder sb = new StringBuilder();

        sb.append("\\\n");
        sb.append(" \\ ^__^\n");
        sb.append("  \\(oo)\\_______\n");
        sb.append("   (__)\\       )\\/\\\n");
        sb.append("        ||----w |\n");
        sb.append("        ||     ||\n");        
        return sb.toString();
    }

    public static String getBear(){
        StringBuilder sb = new StringBuilder();
        sb.append("    \\\n");
		sb.append("     \\\n");
		sb.append("      \\\n");
        sb.append("         __         __\n");
        sb.append("        /  \\.-\"\"\"-./  \\\n");
        sb.append("        \\    -   -    /\n");
        sb.append("         |   o   o   |\n");
        sb.append("         \\  .-'''-.  /\n");
        sb.append("          '-\\__Y__/-'\n");
        sb.append("             `---`\n");

        return sb.toString();
    }

    public static String getBeavis(){

        StringBuilder sb = new StringBuilder();
        sb.append("    \\\n");
		sb.append("     \\\n");
		sb.append("      \\\n");
        sb.append("            _------__--___.__.\n");
        sb.append("          /            `  `    \\\n");
        sb.append("         |                      \\\n");
        sb.append("         |                       |\n");
        sb.append("          \\                      |\n");
        sb.append("            ~/ --`-`-`-\\         |\n");
        sb.append("            |            |       |\n");
        sb.append("            |            |       |\n");
        sb.append("             |   _--    |       |\n");
        sb.append("              | =-.    |.-.    |\n");
        sb.append("             o|/o/       _.   |\n");
        sb.append("             /  ~          \\ |\n");
        sb.append("           (____@)  ___~    |\n");
        sb.append("              |_===~~~.`    |\n");
        sb.append("           _______.--~     |\n");
        sb.append("          \\________       |\n");
        sb.append("                   \\      |\n");
        sb.append("                 __/-___-- -__\n");
        sb.append("                /            __\\\n");
        sb.append("               /-| Metallica|| |\n");
        sb.append("              / /|          || |\n");
        return sb.toString();
    }

    

}
