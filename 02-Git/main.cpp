

#include <iostream>
#include <stdlib.h> 
#include <string.h> 

bool is_good_option(std::string & user_input) {
    static const char *good_options[] = {
        "r", "p", "s", "q"
    };
    for (auto good_option : good_options) {
        if (user_input == good_option) {
            return true;
        }
    }
    return false;
}

typedef struct {
    const char *short_option;
    const char *name;
} GAME_OPTION;

GAME_OPTION game_options[] = {
    {"r", "rock"},
    {"p", "paper",},
    {"s", "scissors"}
};

#define NUMBER_OF_GAME_OPTIONS (sizeof (game_options) / sizeof (GAME_OPTION))

const char * bot_picks() {
    return game_options[ rand() % NUMBER_OF_GAME_OPTIONS ].short_option;
}

const char * get_option_name_by_code(const char *option_code) {
    for (auto option : game_options) {
        if (strcmp(option.short_option, option_code) == 0) {
            return option.name;
        }
    }
    return "unk";
}

int main() {

    std::cout << "Rock / Paper / Scissors gambling game (single player - human vs computer) @ Bot Inc." << std::endl;


    while (1) {
        std::string user_choice;
        do {
            std::cout << "Please choose: rock (r) - paper (p) - scissors (s); And press 'q' when you get bored" << std::endl;
            std::cin >> user_choice;
        } while (!is_good_option(user_choice));
        
        if (user_choice == "q") {
            break;
        }

        std::string bot_choice = bot_picks();

        std::cout
                << "You choose " << get_option_name_by_code(user_choice.c_str())
                << ", I choose " << get_option_name_by_code(bot_choice.c_str())
                << std::endl;

        //TODO: add decision logic here
        
    }


    return 0;
}
