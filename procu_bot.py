import requests
import random
from telegram import Update, InlineKeyboardMarkup, InlineKeyboardButton
from telegram.ext import Updater, CommandHandler, CallbackContext, MessageHandler, Filters, CallbackQueryHandler
import time
from telegram import ParseMode

# Definisci il tuo URL API di Telegram
TELEGRAM_API_URL = "https://api.telegram.org/bot6566333223:AAFRbU8Mu-09TEMHC1VORTRrFlDTmf8VNXc"

# # Definisci le parole chiave per ciascuna categoria
# categorie_parole_chiave = {
#     'saluto': ['ciao', 'ragazzi'],
#     # Aggiungi altre categorie e parole chiave secondo necessità
# }

# Definisci le frasi associate a ciascuna categoria
frasi_per_categoria = {
    'PROCU SALUTO': ['Ciao, buon lavoro', 'Ciao a tutti ragazzi', 'No ragazzi oggi è così'],
    'PROCU ON WORK': ['Aprimi una card ', 'Kafka to Kafka ', 'Contingency ','Dai phasiamoci ','Ti pingo io ','Ti Chatto dopo ','Se vuoi ti puoi staccare ']
    # Aggiungi altre categorie e frasi secondo necessità
}

def determina_categoria(parola):
    # Parole chiave e le rispettive categorie associate
    parole_chiave_categorie = {
        'ciao': 'saluto',
        'ragazzi': 'saluto',
        # Aggiungi altre parole chiave e categorie secondo necessità
    }

    # Confronta la parola con le parole chiave e restituisci la categoria se trovata
    for parola_chiave, categoria in parole_chiave_categorie.items():
        if parola.lower() in parola_chiave.lower():
            return categoria

    # Restituisci None se nessuna categoria è stata trovata per la parola
    return None


# Funzione per gestire i pulsanti inline
# Funzione per gestire i pulsanti inline
# Funzione per gestire i pulsanti inline
def inline_button_handler(update: Update, _: CallbackContext) -> None:
    query = update.callback_query
    query.answer()

    if query.data == 'search':
        # Invia una lista di categorie all'utente
        categorie_buttons = [
            [InlineKeyboardButton(categoria, callback_data=f'categoria:{categoria}')]
            for categoria in frasi_per_categoria.keys()
        ]
        reply_markup = InlineKeyboardMarkup(categorie_buttons)
        query.message.reply_text("Scegli una categoria:", reply_markup=reply_markup)
        

        #query.message.reply_text("Scegli una categoria:", reply_markup=reply_markup)
    elif query.data.startswith('categoria:'):
        # Estrai la categoria dalla data del pulsante
        _, categoria_scelta = query.data.split(':')
        if categoria_scelta in frasi_per_categoria:
            # Scegli una frase casuale dalla categoria selezionata
            frase_scelta = random.choice(frasi_per_categoria[categoria_scelta])
            # Invia la frase al chat ID specificato
           # Invia la frase al chat ID specificato con ParseMode.HTML
            #query.message.reply_text(f'{frase_scelta}')
            query.message.reply_text(f'✨ {frase_scelta} ✨')

            # Invia uno sticker dopo la risposta
            sticker_id = "ID_DEL_TUO_STICKER"  # Sostituisci con l'ID dello sticker desiderato
            query.message.reply_sticker(sticker=sticker_id)
    
            #delay
            time.sleep(1)



            # Invia nuovamente la lista di categorie all'utente per una nuova scelta
            categorie_buttons = [
                [InlineKeyboardButton(categoria, callback_data=f'categoria:{categoria}')]
                for categoria in frasi_per_categoria.keys()
            ]
            reply_markup = InlineKeyboardMarkup(categorie_buttons)
            query.message.reply_text("Scegli una categoria:", reply_markup=reply_markup)



# Funzione per il comando /cerca
def cerca_command(chat_id, parola):
    query = update.callback_query
    query.answer()

    if query.data == 'search':
        query.message.reply_text("Inserisci la parola da cercare usando il comando /cerca <parola>.")
    elif query.data.startswith('search_command:'):
        _, parola = query.data.split(':')
        categoria = determina_categoria(parola)
        if categoria:
            query.message.reply_text(f'La categoria per la parola "{parola}" è: {categoria}')
        else:
            query.message.reply_text(f'Nessuna categoria trovata per la parola "{parola}".')

# Funzione per gestire il comando /start
def start(update: Update, _: CallbackContext) -> None:
    user = update.message.from_user
    keyboard = [
    [InlineKeyboardButton(" CIAO SONO IL PROCURATORE,CHIEDI PURE: 🔍", callback_data='search')]
]
    reply_markup = InlineKeyboardMarkup(keyboard)
    update.message.reply_text(
        fr'Ciao, amigo! Premi il pulsante per fare una ricerca.',
        reply_markup=reply_markup
    )

# Funzione principale per avviare il bot
def main() -> None:
    # Sostituisci 'TOKEN_DEL_TUO_BOT' con il token del tuo bot Telegram
    updater = Updater("6566333223:AAFRbU8Mu-09TEMHC1VORTRrFlDTmf8VNXc")

    # Ottieni il dispatcher per registrare i gestori dei comandi
    dispatcher = updater.dispatcher

    # Registra i gestori dei comandi
    dispatcher.add_handler(CommandHandler("start", start))
    dispatcher.add_handler(CommandHandler("cerca", cerca_command))

    # Nella funzione principale, sostituisci questa linea:
    dispatcher.add_handler(CallbackQueryHandler(inline_button_handler, pattern='^(categoria:.+)$'))
    # Con questa linea:
    dispatcher.add_handler(CallbackQueryHandler(inline_button_handler, pattern='^(search|categoria:.+|categorie)$'))

    # Avvia il bot
    updater.start_polling()

    # Attendi che il bot sia fermato manualmente
    updater.idle()

if __name__ == '__main__':
    main()

